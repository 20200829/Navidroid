public class FunctionNameChecker {
    public boolean isClickFunction(String funcName){
        return "onClick".equals(funcName) || "onLongClick".equals(funcName) || "onItemClick".equals(funcName) ||
                "onItemLongClick".equals(funcName);

    }

    public boolean isSetClickFunction(String funcName){
        return "setOnClickListener".equals(funcName) || "setOnLongClickListener".equals(funcName) ||
                "setOnItemClickListener".equals(funcName) || "setOnItemLongClickListener".equals(funcName);

    }
}
