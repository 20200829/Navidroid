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
To understand the issues during manual exploratory testing, we carry out an empirical study on observing testers' behavior. The details of the empirical study are shown in ./EmpiricalStudy/.

## Effectiveness Evaluation
We compared our NaviDroid with five baselines, For more details, see ./EffectivenessEvaluation/.

## Usefulness Evaluation
In addition to the effectiveness evaluation, we also conduct a user study to demonstrate the usefulness of NaviDroid in the real-world practice of manual testing. For more details, please see the table and ./UsefulnessEvaluation/.

**id** | **App Name** |**Categories** |**Issueid** |**Status** |**experiment** |**control** |**experiment** |**control** |**experiment** |**control** |**experiment** |**control**
:-: | :-: | :-: | :-: |  :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-:
1 | Pausing Healthily | Health | #28 | confirm | 0.80** | 0.68 | 1.77** | 5.74 | 2 | 1.25 | 5 | 5 
2 | Weather | Internet | #126 | fixed | 0.81** | 0.62 | 2.12** | 5.29 | 2.75 | 1.25 | 5 | 5 
3 | Contact book | Phone | #6 | confirm | 0.80* | 0.68 | 1.96** | 6.13 | 2 | 1 | 5 | 4.5 
4 | Money tracker | Finance | #7 | fixed | 0.93** | 0.70 | 3.86** | 8.24 | 2 | 1 | 5 | 4.5 
5 | OpenFoodFacts | Health | #3051 | confirm | 0.79* | 0.67 | 6.49** | 8.72 | 3 | 0.5 | 5 | 4.5 
6 | GPSTest | Navig | #467 | fixed | 1.00 | 1.00 | 3.31* | 6.08 | 1 | 1 | 5 | 4.5 
7 | Password Store | Security | #1262 | fixed | 0.74* | 0.43 | 6.37** | 8.91 | 1 | 0 | 4.5 | 4.5 
8 | NewPipe | Media | #5289 | fixed | 0.90** | 0.68 | 4.36** | 6.93 | 2 | 0.5 | 5 | 4.5 
9 | WallETH | Finance | #485 | fixed | 0.63** | 0.44 | 7.57* | 8.60 | 1 | 0 | 4.5 | 3.5 
10 | Transistor | Media | #254 | fixed | 1.00 | 1.00 | 3.29** | 6.33 | 1 | 0 | 5 | 4.5 
11 | DemocracyDroid | News | #51 | confirm | 1.00 | 0.85 | 5.07* | 7.62 | 2 | 0.75 | 5 | 4.5 
12 | Metrodroid | Navig | #744 | fixed | 0.85** | 0.63 | 5.95** | 8.01 | 1 | 0 | 5 | 4.5 
13 | INSTEAD | Game | #15 | confirm | 0.83** | 0.75 | 4.25** | 7.79 | 1 | 0 | 5 | 4.5 
14 | OpenChaosChess | Game | #22 | fixed | 0.90* | 0.65 | 6.14** | 8.04 | 1 | 0.25 | 5 | 4.5 
15 | RailwayStationP | Navig | #211 | fixed | 0.81* | 0.53 | 7.07** | 8.62 | 1 | 0.25 | 5 | 4.5 
16 | PocketMaps | Travel | #155 | confirm | 0.71** | 0.54 | 5.51* | 8.65 | 2 | 0.25 | 5 | 4.5 
17 | Barinsta | Internet | #455 | fixed | 1.00 | 0.85 | 3.28** | 6.69 | 1 | 1 | 5 | 4.5 
18 | Fit Notif | Connect | #22 | confirm | 0.70** | 0.60 | 6.71* | 7.46 | 1 | 0 | 4.5 | 4.5 
19 | SkyTube | Media | #867 | fixed | 0.86** | 0.68 | 5.25** | 8.15 | 1 | 0.25 | 5 | 4.5 
20 | LibreraReader | Reading | #652 | fixed | 0.80** | 0.60 | 6.55* | 8.23 | 1 | 0 | 5 | 4.5 






