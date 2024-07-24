package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        examples();
        section01();
        section02();
        section03();
        clairesCookies();
        elliotsYardCare();
    }

    public static void examples()
    {
        // i. Create a variable that stores the name of the best
        // programming language.
        String bestLanguage;
        bestLanguage = "Java";

        System.out.println("i) Best Programming Language");
        System.out.println("language: " + bestLanguage);
        System.out.println();



        // ii. Create a variable to store the speed limit in
        // a school zone.
        int speedLimit;
        speedLimit = 20;

        System.out.println("ii) Speed Limit");
        System.out.println("speedLimit: " + speedLimit);
        System.out.println();
    }

    public static void section01()
    {
        /******************** Section 1 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 1: Declaring Variables");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();


        // 1. Declare a new variable to hold your name.
        // Variable name: name
        // Data Type: string (names/words are strings)
        String name = "Tabatha";
        System.out.println("Name: " +name);
        System.out.println();


        // 2. Declare a variable to hold your age.
        // Variable name: age
        // Data Type: int (age is a whole number)
        int age = 36;
        System.out.println("Age: " +age);
        System.out.println();

        // 3. Declare a variable that holds the first 5 digits of PI.
        // Variable name: pi
        // Data Type: double (pi is a number with decimal places)
        double pi = 3.1415;
        System.out.println("Pi: " +pi);
        System.out.println();

        // 4. Declare a variable holds the price of
        // an adult meal at the buffet.
        // Variable name: price
        // Data Type: double (price contains a dollar and cent value)

        // NOTE: the decimal data type  is not automatically recognized
        // see lecture notes
        double price = 19.99;
        System.out.println("Price: $" +price);
        System.out.println();
    }

    public static void section02()
    {

        /******************** Section 2 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 2: Selecting DataTypes");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        // From this point forward you will need to choose
        // the variable name for each of your variables
        // as well as the DataType that will be used for
        // each variable.



        // 5. Declare a variable to store the name of your
        // favorite super hero.

        // Hint: You cannot use the same variable name
        // as a variable that you have used before.

        String FavoriteHeroName = "Dazzler";
        System.out.println("Favorite Super Hero: " +FavoriteHeroName);
        System.out.println();



        // 6. Declare a variable to hold the value of
        // value of a test score. The test has 100
        // questions and each question is worth 1 point.
        // (You can choose the score)

        int TestScore = 100;
        System.out.println("Test Score: " +TestScore);
        System.out.println();



        // 7. Declare a variable that holds the current
        // population in the United States.
        // (search what the population is today)

        int CurrentUSAPopulation = 341814420;
        System.out.println("Current population in the USA: " +CurrentUSAPopulation);
        System.out.println();



        // 8. Declare a variable that holds the current
        // population in China.
        // (search what the population is today)

        int CurrentChinaPopulation = 1425178782;
        System.out.println("Current population in China: " +CurrentChinaPopulation);
        System.out.println();



        // 9. Declare a variable that holds the current
        // population in the world.
        // (search what the population is today)
        // need to add l after the long number & before semicolon)

        long CurrentWorldPopulation = 8122914525l;
        System.out.println("Current population in the world: " +CurrentWorldPopulation);
        System.out.println();



        // 10. Declare a variable that specifies whether
        // or not your mouse is wireless.

        boolean isMouseWireless = true;
        System.out.println("Wireless Mouse: " +isMouseWireless);
        System.out.println();



        // 11. Search what the Latitude and Longitude of your
        // home town are. Then declare 2 variables
        // to store the Latitude and Longitude.

        String Hometown = "Rio de Janeiro";
        float HometownLatitude = 22.9068f;
        float HometownLongitude = 43.1729f;
        System.out.println("My hometown: " +Hometown);
        System.out.println("Latitude: " +HometownLatitude);
        System.out.println("Longitude: " +HometownLongitude);
        System.out.println();



        // 12. Create a variable that holds the current
        // Microsoft stock price.

        float MicrosoftStockPrice = 444.85f;
        System.out.println("Current Microsoft's Stock Price: $" +MicrosoftStockPrice);
        System.out.println();
    }
    
    public static void section03()
    {
        /******************** Section 3 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 3: Expressions and Arithmetic");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        /*
         * In this section you are expected to create
         * multiple variables in each exercise. You should
         * create as many variables as you need in order to
         * solve each problem.
         *
         * Make sure that your variable names are meaningful
         * and that the name describes the purpose of the
         * variable. Also, your code should not have any
         * "magic numbers" but anyone who reads the code
         * should be able to understand your code and
         * the calculations.
         */

        System.out.println("----------------------------");
        System.out.println("Backyard Basketball");
        System.out.println("-----------------------------");
        System.out.println();


        // 13. In his last basketball game Pete made 7 shots,
        // but missed 3 of his shots.

        System.out.println("\u2022 Pete's Last Game Stats:");
        int BasketballShotsMade = 7;
        int BasketballShotsMissed = 3;
        System.out.println("Shots made: " +BasketballShotsMade);
        System.out.println("Shots missed: " +BasketballShotsMissed);

        // How many shots did Pete take?

        int BasketballShotsTaken = BasketballShotsMade + BasketballShotsMissed;
        System.out.println("Total shots taken: "+BasketballShotsTaken);
        System.out.println();

        // 14. In his previous basketball game Pete took 20 shots.
        // He missed 6 shots, and he made 3 three point shots.

        System.out.println("\u2022 Pete's Previous Game Stats:");
        int PreviousShotsMade = 20;
        System.out.println("Shots made: " +PreviousShotsMade);
        int PreviousMissedShots = 6;
        System.out.println("Shots missed: " +PreviousMissedShots);
        int PreviousThreePointShots = 3;
        System.out.println("3-point shots: " +PreviousThreePointShots);

        // How many 2 point shots did Pete make?\

        int PreviousTwoPointShots = PreviousShotsMade - PreviousMissedShots - PreviousThreePointShots;
        System.out.println("2-point shots: " +PreviousTwoPointShots);
        System.out.println();


        // 15. Pete and Pat are teammates. Pete made 6 shots.
        // Pat made twice as many shots as Pete.

        System.out.println("\u2022 Pete & Pat's Game Stats:");
        int PeteShots = 6;
        System.out.println("Pete's shots made: " +PeteShots);

        int PatShots = PeteShots * 2;
        System.out.println("Pat's shots made: " +PatShots);

        // How many total shots did they make?

        int TotalShots = PeteShots + PatShots;
        System.out.println("Total shots: " +TotalShots);
        System.out.println();


        // 16. Pete has made 13 shots, Pat has made 9.

        System.out.println("\u2022 New Pete & Pat's Game Stats:");
        int NewPeteShots = 13;
        int NewPatShots = 9;
        System.out.println("Pete's shots made so far: " +NewPeteShots);
        System.out.println("Pat's shot made so far: " +NewPatShots);



        // If both Pete and Pat make 1 more shot each
        // before the game ends, how many total shots
        // did the Terrifying Twosome make in the game?

        System.out.println("\u2023 If both Pete and Pat make 1 more shot each:");
        NewPeteShots++;
        NewPatShots++;
        int NewTotalShots = NewPeteShots + NewPatShots;
        System.out.println("Total shots: " +NewTotalShots);
        System.out.println();



        // 17. In his last game Pete made 11 shots.
        // he missed 4 shots.

        System.out.println("\u2022 Pete's Last Game:");
        int LastGameShotsMade = 11;
        int LastGameShotsMissed = 4;
        System.out.println("Shots made: " +LastGameShotsMade);
        System.out.println("Shots missed: " +LastGameShotsMissed);


        // What percentage of his shots did he make?

        int LastTotalShots = LastGameShotsMade + LastGameShotsMissed;
        System.out.println("Total shots: " +LastTotalShots);

        int ShotPercentage = (LastGameShotsMade * 100) / 15;
        System.out.println("Percentage of shots made: " +ShotPercentage +"%");
        System.out.println();


        // 18. Pete and Pat have decided to only take 3 point
        // shots in their next game. Together they make 70%
        // of their 3 point shots.

        // The team that they are playing scores 31 points a game.

        // How many shots do Pete and Pat have to take to win
        // this game?



        System.out.println("\u2022 If Pete & Pat only take 3-point shots: ");
        int OpposingTeamScore = 31;
        System.out.println("Opposing team score: " +OpposingTeamScore);
        int PointsNeededToWin = OpposingTeamScore +1;
        int PercentageShotsMade = 70;
        int TotalPointsToWin = (PointsNeededToWin * 100) / PercentageShotsMade;
        int TotalShotsToWin = (TotalPointsToWin / 3) + 1;
        System.out.println("Total Shots to Win: " +TotalShotsToWin);
        System.out.println();

    }
    
    public static void clairesCookies()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Claire's Cookies");
        System.out.println("-----------------------------");
        System.out.println();



        // 19. Claire sells cookies by the dozen. Sean has 14 students
        // in his class. He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. How many cookies will each student
        // receive? (Students can only receive whole cookies)



        // 20. Sean has 14 students in his class.
        // He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. After giving the students their
        // cookies, how many cookies will be left over?



        // 21. Sean's class has earned a cookie party.

        // If Sean has 14 students, how many dozen cookies
        // does he need to buy from Claire's Cookies so that
        // each student can receive 3 cookies.



        // 22. Sean's class has earned a cookie party. The number
        // of cookies that a student receives depends on
        // the score that they received on the cookie test.
        // Sean has 14 students.

        // 100 = 4 cookies
        // 90+ = 3 cookies
        // everyone else 2 cookies

        // Sean has 14 students. Chuck and Andrea scored
        // a perfect 100 on the test. Regina, Glen, Tony and Lorrie
        // all scored above 90. The rest of the class scored
        // below 90.

        // How many dozen cookies does Sean need to buy.



        // 23. If Claire's Cookies sells each dozen cookies for 12.99,
        // how much will it cost Sean to buy 4 dozen cookies.



        // (Use this information for the next several questions)
        // Claire now charges different prices for different
        // types of cookies as follows:

        // Snicker Doodles = $12.99 / dz
        // Chocolate Chip = $13.99 / dz
        // Frosted Chocolate Chip = $15.99 / dz

        // Each dozen cookies must be the same type of cookie.

        // Sean has allowed his students to choose 3
        // cookies each. Here is what they have selected

        // Snicker Doodles | Chocolate Chip | Frosted Chocolate Chip
        // ---------------------------------------------------------
        // 9                 15               18

        // 24. How many total dozen cookies does Sean need to buy?



        // 25. What is the total cost of this order?



        // 26. How many cookies will be left over of each type of cookie?
        // (Snicker Doodles, Chocolate Chip, Frosted Chocolate Chip)



        // 27. How much money could Sean have saved if he would
        // have bought: 2 dz Frosted Chocolate Chip
        //              1 dz Chocolate Chip
        //              1 dz Snicker Doodle
    }


    // bonus - challenge
    public static void elliotsYardCare()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Elliot's Yard Care");
        System.out.println("----------------------------");
        System.out.println();

        // Use the following information to answer the remaining questions.

        // Elliot runs a yard care business named "Elliot's Yard Care".
        // He charges $30 to mow and trim a medium size lawn (100 ft x 50 ft).
        // Elliot takes pride in his work and his lawns look
        // immaculate. In order to maintain such a quality reputation
        // his services include grass clipping removal and
        // complete sweeping of the property after the lawn
        // is mowed.

        // Elliot's goal is to earn at least $10 per hour.
        // It costs him about $2.50 in materials and gas per 1000 sq ft.
        // On average elliot has calculated that it takes him roughly
        // 45 minutes to fully maintain 1000 sq ft.


        // 28. What is the total cost to Elliot when
        // he mows a yard that is 100 x 50 feet?



        // 29. How much total money does Elliot earn
        // to maintain a 100 x 50 ft yard?



        // 30. How much time does it take Elliot to mow
        // a 100 x 50 ft yard?



        // 31. How much money does Elliot earn per hour
        // on a 100 x 50 foot yard?



        // 32. What is Elliot's cost per hour on a medium
        // sized yard?



        // 33. How much money should Elliot charge for a medium yard
        // in order to earn $10 per hour?


    }
}