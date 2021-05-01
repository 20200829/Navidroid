## Usefulness Evaluation
In addition to the effectiveness evaluation, we also conduct a user study to demonstrate the usefulness of NaviDroid in the real-world practice of manual testing. For more details, please see the ./Usefulness.zip.

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

Regarding the user experience of Navidroid, we also create an online survey on the participants from our user study. We asked them about the usefulness of the Navidroid for their work, as well as the potential and expansion of the Navidroid in the future.  At the end, participants fill in the System Usability Scale (SUS) questionnaire (5-point Likert scale~\cite{5-likert-1} from 1 (strongly disagree) to 5 (strongly agree)). The questionnaire also asks participants to select the TechLand system features that they deem most useful or least useful for the tasks.

<img src="https://github.com/20200829/Navidroid/blob/main/useful-SUS.png" width="600" alt="" align=center >

Figure summarizes the users’ ratings of the 10 system design and usability questions in the System Usability Scale questionnaire. The upper half of figure shows that users agree or strongly agree that our Navidroid is easy to use and the features of the Navidroid are well integrated. The lower half of figure further confirms the simplicity and consistency of our Navidroid. Furthermore, the average helpfulness of the Navidroid for the tasks is 4.42, which indicates that participants appreciate the help of the Navidroid in the tasks.
