## Due to the needs of our project, the integrated tool is comming soon. For questions, please contact liuzhe181@mails.ucas.edu.cn



## How to do?
Navidroid can run on Mac OS or Window 10 or Ubuntu. The following are the specific steps:

## Setup
The following is required to set up Navidroid:
* Python 3.7.3
* Java version "1.7.0_80"
* Genymotion 3.0.4
* Android 8.0
* at least 1 GB hard drive
* 8 GB memory
* Mac OS 10.15.7 or Ububntu 18.04 64-bit or Windows 10 64-bit

## Step 1: Clone repository
```
git clone https://github.com/20200829/Navidroid.git
```

## Step 2: Extract STG
Put the application source code (such as ./Health) in the current directory (./Navidroid/NavidroidSourceCode/GetAction/).
```
javac ./main.java
java ./main
```
Get the output: ./STG_action/

## Step 3: Path recommendation and Visualization
Put the application Apk (such as ./Health.apk) in the current directory. 
Open the usage permissions of the Android virtual machine.
```
python ./Navidroid/NavidroidSourceCode/VisualTool/run.py
```
To run the Navidroid.

<img src="https://github.com/20200829/Navidroid/blob/main/TestExample-1.gif" width="600" alt="Demo" align=center >

## Need help?
* If an error is reported during operation, please check whether the Android virtual machine developer permission is turned on.
* If the system prompts that the version is incorrect, please check the version mentioned above.
* If you have any questions, please submit an issue report in the issue.

