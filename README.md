## Due to the needs of our project, the integrated tool is comming soon. Please contact liuzhe181@mails.ucas.edu.cn

# Navidroid
Mobile apps are now indispensable for people's daily life. Complementing with automated GUI testing, manual GUI testing is the last line of defence for app quality especially in spotting usability and accessibility issues which are hard to detect by automated testing. However, the repeated actions and easily missing of some functionalities make manual testing time-consuming, labor-extensive and inefficient. Inspired by the game candy crush with flashy candies as hint moves for players, we develop a tool named NaviDroid for navigating human testers via highlighted next operations for more effective and efficient testing.

We release the source code in **./NavidroidSourceCode/**, empirical study details in **./EmpiricalStudy/**, dataset details in **./Dataset/**, experiment details in **./EffectivenessEvaluation/** & **./UsefulnessEvaluation/**, and demo videos of Navidroid.

## Demo Video
This is a demo video of the Navidroid. The Navidroid prompts testers for UI components that need to be operated (e.g., red bounding box). That process is similar to the flashing candies (hint/suggested moves) when a player hesitates to make a move in playing Candy Crush (a popular free-to-play match-three puzzle video game).

<img src="https://github.com/20200829/Navidroid/blob/main/TestExample-1.gif" width="600" alt="Demo" align=center >


## Example NaviDroid Usage Scenario
During manual GUI testing, our Navidroid will trace testers' testing steps and help navigate or remind testers with unexplored pages by explicit visual annotations (e.g., red bounding box) in the run-time page as seen in the Figure.

<img src="https://github.com/20200829/Navidroid/blob/main/ExampleNaviDroid.png" width="600" alt="" align=center >


## Dataset
We randomly select 85 apps from F-Droid, including 17 categories (e.g., connectivity, games, internet, money, reading, education, health) with 5 latest (in Oct. 2020) released apps in each category. The details and apks of the data are shown in Figure and ./Dataset/.

<img src="https://github.com/20200829/Navidroid/blob/main/dataset.png" width="600" alt="" align=center >

## Empirical Study
To understand the issues during manual exploratory testing, we carry out an empirical study on observing testers' behavior. The details of the empirical study are shown in ./EmpiricalStudy/ and Figure.

<img src="https://github.com/20200829/Navidroid/blob/main/exampleEmpirical.png" width="600" alt="" align=center >

Example of one tester's exploration graph. The solid line represent the explored path while dotted line is the unexplored path. Number below each page is the visit time of the tester

To understand the issues during manual exploratory testing, we carry out an empirical study on observing testers' behavior.
With more details of the experiment can download file ***EmpiricalStudy.zip*** , ***EmpiricalStudy.zip*** contains the statistical data (***empirical-study.csv*** ) of the empirical study and the basis for determining the threshold ***empirical-study.txt*** (the specific content of the empirical study).

## Effectiveness Evaluation
We compared our NaviDroid with five baselines, For more details, see ./EffectivenessEvaluation/.
We also try the other fine-grained metric, the number of unique states explored by the tool. In our experiments, we also get the result in 85 apps from our dataset, as seen in the table below. On average, Navidroid can get 52.7 states which is 27% higher than the best baseline. We had omitted the results from the submitted version for space reasons, but we put it on our GitHub.

 ***Navidroid*** | IC3 | Monkey | Droidbot | Droidmate | Humaniod 
:-: | :-: | :-: | :-: |  :-: | :-:
 ***52.7*** | 17.7 | 24.3 | 29.3 | 35.9 | 41.5 

## Usefulness Evaluation
In addition to the effectiveness evaluation, we also conduct a user study to demonstrate the usefulness of NaviDroid in the real-world practice of manual testing. For more details, please see the table and ./UsefulnessEvaluation/.

**id** | **App Name** |**Categories** | **Activity-number** | **Intent-number** | **Download** |**Issueid** |**Status** |**experiment** |**control** |**experiment** |**control** |**experiment** |**control** |**experiment** |**control**
:-: | :-: | :-: | :-: |  :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: 
1 | Pausing Healthily | Health | 9 | 22 | 10K+ | #28 | confirm | 0.80** | 0.68 | 1.77** | 5.74 | 2 | 1.25 | 5 | 5 
2 | Weather | Internet | 8 | 18 | 1K+ | #126 | fixed | 0.81** | 0.62 | 2.12** | 5.29 | 2.75 | 1.25 | 5 | 5 
3 | Contact book | Phone | 8 | 20 | 5K+ | #6 | confirm | 0.80* | 0.68 | 1.96** | 6.13 | 2 | 1 | 5 | 4.5 
4 | Money tracker | Finance | 10 | 25 | 5K+ | #7 | fixed | 0.93** | 0.70 | 3.86** | 8.24 | 2 | 1 | 5 | 4.5 
5 | OpenFoodFacts | Health | 19 | 45 | 10M+ | #3051 | confirm | 0.79* | 0.67 | 6.49** | 8.72 | 3 | 0.5 | 5 | 4.5 
6 | GPSTest | Navig | 5 | 8 | 5K+ | #467 | fixed | 1.00 | 1.00 | 3.31* | 6.08 | 1 | 1 | 5 | 4.5 
7 | Password Store | Security | 22 | 50 |10M+ | #1262 | fixed | 0.74* | 0.43 | 6.37** | 8.91 | 1 | 0 | 4.5 | 4.5 
8 | NewPipe | Media | 10 | 22 | 100M+ | #5289 | fixed | 0.90** | 0.68 | 4.36** | 6.93 | 2 | 0.5 | 5 | 4.5 
9 | WallETH | Finance | 30 | 68 | 10M+ | #485 | fixed | 0.63** | 0.44 | 7.57* | 8.60 | 1 | 0 | 4.5 | 3.5 
10 | Transistor | Media | 5 | 10 | 1M+ | #254 | fixed | 1.00 | 1.00 | 3.29** | 6.33 | 1 | 0 | 5 | 4.5 
11 | DemocracyDroid | News | 5 | 12 | 5K | #51 | confirm | 1.00 | 0.85 | 5.07* | 7.62 | 2 | 0.75 | 5 | 4.5 
12 | Metrodroid | Navig | 13 | 28 | 5M+ | #744 | fixed | 0.85** | 0.63 | 5.95** | 8.01 | 1 | 0 | 5 | 4.5 
13 | INSTEAD | Game | 6 | 10 | 1K+ | #15 | confirm | 0.83** | 0.75 | 4.25** | 7.79 | 1 | 0 | 5 | 4.5 
14 | OpenChaosChess | Game | 10 | 22 | 1K+ | #22 | fixed | 0.90* | 0.65 | 6.14** | 8.04 | 1 | 0.25 | 5 | 4.5 
15 | RailwayStationP | Navig | 16 | 30 | 50K+ | #211 | fixed | 0.81* | 0.53 | 7.07** | 8.62 | 1 | 0.25 | 5 | 4.5 
16 | PocketMaps | Travel | 14 | 34 | 100K+ |#155 | confirm | 0.71** | 0.54 | 5.51* | 8.65 | 2 | 0.25 | 5 | 4.5 
17 | Barinsta | Internet | 5 | 10 | 10K+ | #455 | fixed | 1.00 | 0.85 | 3.28** | 6.69 | 1 | 1 | 5 | 4.5 
18 | Fit Notif | Connect | 10 | 24 | 5K+ | #22 | confirm | 0.70** | 0.60 | 6.71* | 7.46 | 1 | 0 | 4.5 | 4.5 
19 | SkyTube | Media | 7 | 14 | 50M+ | #867 | fixed | 0.86** | 0.68 | 5.25** | 8.15 | 1 | 0.25 | 5 | 4.5 
20 | LibreraReader | Reading | 10 | 22 | 100M+ | #652 | fixed | 0.80** | 0.60 | 6.55* | 8.23 | 1 | 0 | 5 | 4.5 

Regarding the user experience of Navidroid, we also create an online survey on the participants from our user study. We asked them about the usefulness of the Navidroid for their work, as well as the potential and expansion of the Navidroid in the future.  At the end, participants fill in the System Usability Scale (SUS) questionnaire (5-point Likert scale from 1 (strongly disagree) to 5 (strongly agree)). The questionnaire also asks participants to select the TechLand system features that they deem most useful or least useful for the tasks.

<img src="https://github.com/20200829/Navidroid/blob/main/useful-SUS.png" width="600" alt="" align=center >

Figure summarizes the users’ ratings of the 10 system design and usability questions in the System Usability Scale questionnaire. The upper half of figure shows that users agree or strongly agree that our Navidroid is easy to use and the features of the Navidroid are well integrated. The lower half of figure further confirms the simplicity and consistency of our Navidroid. Furthermore, the average helpfulness of the Navidroid for the tasks is 4.42, which indicates that participants appreciate the help of the Navidroid in the tasks.

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



