# ArduEasy
This program is developed as part of a 4th semester Software Engineering project on Aalborg University.

<img src="https://user-images.githubusercontent.com/16747705/93992307-ad6c6680-fd8d-11ea-872f-52ce9958b863.png" width="100">

This program implements a compiler and a programming language with focus on home automation.

On the left side ArduEasy code, on the right side the corresponding Arduino code
![image](https://user-images.githubusercontent.com/16747705/93993717-5d8e9f00-fd8f-11ea-854d-ae6bed922765.png)

## Project Period

4th Semester, Spring 2018

## ArduEasy Code
House setup:
```C
house
{
    Temp = PIN A 12 as input
    CurrentTime = PIN A 13 as input
    time SavedTime = 00:00
    
    room Kitchen
    {
        Lamp1 = PIN 1 as output
        Lamp2 = PIN 2 as output
        CoffeeMachine = PIN 3 as output
        Button = PIN 4 as input
        Window = PIN 5 as output
        Lamps = {Lamp1, Lamp2}
    }
        room Bedroom
    {
        Blinds1 = PIN 6 as output
        Blinds2 = PIN 7 as output
        Blinds3 = PIN 8 as output
        Blinds = {Blinds1, Blinds2, Blinds3}
    }
}
```
Conditions:
```C
when (house.Kitchen.Button is true)
{
    float Fahrenheit = CelciusToFahrenheit(Temp)
    house.Kitchen.CoffeeMachine = true
    SavedTime = house.CurrentTime
    
    if (SavedTime + 00:15 is house.CurrentTime && Fahrenheit is above or equal 64)
    {
        int i = 0
        house.Kitchen.Window = true //Opens the window 15 mins after the coffee machine turned on if Fahrenheit >= 64.
    }
}
when (Time is 07:00)
{
    house.Bedroom.Blinds = true //This will open the blinds at 7.
    house.Kitchen.Lamps = true //Turns on the Lamps in the Kitchen
}
when (Time is 18:00)
{
    house.Bedroom.Blinds = false //This will close the blinds at 18.
}
function float CelciusToFahrenheit(int temp)
{
    float result = temp * 1.8 + 32
    return result
}
```

## Contributors
 - [Alexander Haarbye Jensen](https://github.com/Alechj)
 - [Jonas Grann Alsen](https://github.com/AlsenDev)
 - [Lasse Lundbo](https://github.com/llundbo)
 - [Lukas Rønsholt](https://github.com/LukasRH)
 - [Magnus Tolderlund Boisen](https://github.com/boisenme)
 - [Rasmus Egholm Nielsen](https://github.com/ralled96)

## Semester Report
The report written along with this program: [ArduEasy.pdf](https://github.com/AAU-projects/P4-ArduEasy/files/5266968/ArduEasy_sw403f18.pdf)

## License
This project uses the following license: [MIT](./LICENSE)
