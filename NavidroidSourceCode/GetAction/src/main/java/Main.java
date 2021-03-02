import com.alibaba.fastjson.JSONObject;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.expr.ClassExpr;


import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws Exception {
        FileOutputStream bos = new FileOutputStream("2.txt");
        System.setOut(new PrintStream(bos));
        File projectDir = new File("contacts");
        listActivityTransfer(projectDir);

    }

    public static void listActivityTransfer(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {



            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            FunctionNameChecker checker = new FunctionNameChecker();
            HashMap<String, List<HashMap<String, String>>> methodTransfer = new HashMap<>();
            HashMap<String, List<HashMap<String, String>>> buttonTransfer = new HashMap<>();
            try {
                CompilationUnit cu = StaticJavaParser.parse(file);
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(ObjectCreationExpr oce, Object arg) {
                        super.visit(oce, arg);
                        if (oce.getChildNodes().size() != 3) {
                            return;
                        }
                        String sourceActivity = "";
                        String destActivity = "";
                        for (Node childNode : oce.getChildNodes()) {
                            if (childNode instanceof ClassOrInterfaceType) {
                                ClassOrInterfaceType classType = (ClassOrInterfaceType) childNode;
                                if (!classType.getName().toString().equals("Intent")) {
                                    return;
                                }
                            }
                            if (childNode instanceof ThisExpr) {
                                sourceActivity = childNode.toString().replace(".this", "");
                            }
                            if (childNode instanceof ClassExpr) {
                                destActivity = childNode.toString().replace(".class", "");
                            }
                        }
                        if (sourceActivity.equals("") || destActivity.equals("")) {
                            return;
                        }
                        System.out.println("sourceActivity: " + sourceActivity);
                        System.out.println("destActivity: " + destActivity);
                        HashMap<String, String> curTransfer = new HashMap<>();
                        curTransfer.put("sourceActivity", sourceActivity);
                        curTransfer.put("destActivity", destActivity);

                        Optional<Node> parentOption = oce.getParentNode();
                        while (parentOption.isPresent()) {
                            Node parent = parentOption.get();
                            if (parent instanceof MethodDeclaration) {
                                MethodDeclaration md = (MethodDeclaration) parent;
                                if (checker.isClickFunction(md.getName().toString())) {

                                    Optional<Node> opParentNode1 = md.getParentNode();
                                    if (opParentNode1.isPresent()) {
                                        Node parentNode1 = opParentNode1.get();
                                        Optional<Node> opParentNode2 = parentNode1.getParentNode();
                                        if (opParentNode2.isPresent()) {
                                            Node parentNode2 = opParentNode2.get();
                                            if (parentNode2 instanceof MethodCallExpr && checker.isSetClickFunction(((MethodCallExpr) parentNode2).getName().toString())) {
                                                String buttonName = ((MethodCallExpr) parentNode2).getScope().get().toString();
                                                System.out.println("case button.setOnClickListener(), button name: " + buttonName);
                                                System.out.println("");
                                                if (buttonTransfer.containsKey(buttonName)) {
                                                    buttonTransfer.get(buttonName).add(curTransfer);
                                                } else {
                                                    List<HashMap<String, String>> tList = new ArrayList<>();
                                                    tList.add(curTransfer);
                                                    buttonTransfer.put(buttonName, tList);
                                                }
                                                break;
                                            } else {
                                                System.out.println("Unexpected case: ");
                                                System.out.println("Node type:" + parentNode2.getClass());
                                                System.out.println("Node Info:" + parentNode2);
                                            }
                                        } else {
                                            System.out.println("Unexpected case: Error: Cannot find parent2");
                                            return;
                                        }
                                    } else {
                                        System.out.println("Unexpected case: Error: Cannot find parent1");
                                        return;
                                    }
                                } else {
                                    String methodName = md.getName().toString();
                                    System.out.println("find define in other method, method name: " + methodName);
                                    if (methodTransfer.containsKey(methodName)) {
                                        methodTransfer.get(methodName).add(curTransfer);
                                    } else {
                                        List<HashMap<String, String>> tList = new ArrayList<>();
                                        tList.add(curTransfer);
                                        methodTransfer.put(methodName, tList);
//                                        System.out.println(tList);
                                    }
                                    break;
                                }
                            }
                            parentOption = parent.getParentNode();
                        }
                    }
                }.visit(cu, null);
            } catch (IOException e) {
                new RuntimeException(e);
            }

            try {
                CompilationUnit cu = StaticJavaParser.parse(file);
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(MethodCallExpr mce, Object arg) {
                        super.visit(mce, arg);
                        String methodName = mce.getName().toString();
                        if (methodTransfer.containsKey(methodName)) {
//                            System.out.println(methodTransfer.get(methodName));
                            Optional<Node> parentOption = mce.getParentNode();
                            while (parentOption.isPresent()) {
                                Node parent = parentOption.get();
                                if (parent instanceof MethodCallExpr) {
                                    MethodCallExpr tMce = (MethodCallExpr) parent;
                                    if (tMce.getName().toString().equals("setOnClickListener")) {
                                        String tButtonName = tMce.getScope().get().toString();
                                        System.out.println(tButtonName + " call method: " + methodName);
                                        List<HashMap<String, String>> tempList = new ArrayList<>();
                                        for (HashMap<String, String> mHash : methodTransfer.get(methodName)){
                                            HashMap<String, String> tempHash = new HashMap<>();
                                            tempHash.putAll(mHash);
                                            tempList.add(tempHash);
                                        }
                                        buttonTransfer.put(tButtonName, tempList);
                                        break;
                                    }
                                }
                                parentOption = parent.getParentNode();
                            }
                        }
                    }
                }.visit(cu, null);
            } catch (IOException e) {
                new RuntimeException(e);
            }
            HashMap<String,String> buttonName2rId = getButtonRId(file);
            HashMap<String, List<HashMap<String, String>>> rIdTransfer = new HashMap<>();
            for (String key : buttonTransfer.keySet()){
                String curRId = buttonName2rId.get(key);
                List<HashMap<String, String>> tempList = new ArrayList<>();
                for (HashMap<String, String> mHash : buttonTransfer.get(key)){
                    HashMap<String, String> tempHash = new HashMap<>();
                    tempHash.putAll(mHash);
                    tempList.add(tempHash);
                }
                rIdTransfer.put(curRId,tempList);
            }
            JSONObject jo = new JSONObject();
            jo.put("rId", rIdTransfer);
            jo.put("button", buttonTransfer);
            jo.put("method", methodTransfer);
            System.out.println(jo);
            System.out.println();
        }).explore(projectDir);
    }

    public static HashMap<String,String> getButtonRId(File curFile) {
        CompilationUnit cu = null;
        HashMap<String,String> buttonName2rId = new HashMap<>();
        try {
            cu = StaticJavaParser.parse(curFile);
            new VoidVisitorAdapter<Object>() {
                @Override
                public void visit(MethodCallExpr mce, Object arg) {
                    super.visit(mce, arg);
                    if ("findViewById".equals(mce.getNameAsString())) {
                        if (mce.getArguments().size() != 1) {
                            return;
                        }
                        String rIdStr = mce.getArgument(0).toString();
                        Optional<Node> optionalNode = mce.getParentNode();
                        if (optionalNode.isEmpty()) {
                            System.out.println("Error: can't find findViewById parent");
                            return;
                        }
                        Node parentNode = optionalNode.get();
                        if (parentNode instanceof AssignExpr) {
                            AssignExpr ae = (AssignExpr) parentNode;
                            String buttonName = ae.getTarget().toString();
                            buttonName2rId.put(buttonName,rIdStr);
                        } else if (parentNode instanceof VariableDeclarator) {
                            VariableDeclarator vd = (VariableDeclarator) parentNode;
                            String buttonName = vd.getNameAsString();
//                            System.out.println(buttonName);
                            buttonName2rId.put(buttonName,rIdStr);
                        } else {
                            System.out.println("Unexcepted case:");
                            System.out.println("parent class:" + parentNode.getClass());
                            System.out.println("parent:" + parentNode);
                        }
                    }
                }
            }.visit(cu, null);
            return buttonName2rId;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
