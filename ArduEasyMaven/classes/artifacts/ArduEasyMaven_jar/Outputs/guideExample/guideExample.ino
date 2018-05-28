int fff = 5;
float bob2 = 5 + 8.5;
int hej = 10 + 5;
int hejhej = 2;
String SavedTime = "00:00";
String NextTime = "12:00";
int house_Kitchen_Lamps[] = {1, 2};
int house_Bedroom_Blinds[] = {6, 7, 8};

void setup()
{
    pinMode(A12, INPUT);
    pinMode(A13, INPUT);
    pinMode(1, INPUT_PULLUP);
    pinMode(2, INPUT_PULLUP);
    pinMode(3, OUTPUT);
    pinMode(4, INPUT);
    pinMode(5, OUTPUT);
    pinMode(6, OUTPUT);
    pinMode(7, OUTPUT);
    pinMode(8, OUTPUT);
}

void loop()
{
    if (digitalRead(4) == true)
    {
        if ((5 > 3) == true)
        {
        }
        analogWrite(A12, 55);
        float Fahrenheit = CelciusToFahrenheit(analogRead(A12));
        digitalWrite(3, true);
        bool test = SavedTime == NextTime;
        if (SavedTime + "00:15" == NextTime && Fahrenheit >= 64 && test)
        {
            digitalWrite(5, true);
        }
    }
    
    if (SavedTime == "07:00")
    {
        for (int i15d25d50901049b6aea49b488d5a611c = 0; i15d25d50901049b6aea49b488d5a611c < 3; i15d25d50901049b6aea49b488d5a611c++)
        {
            digitalWrite(house_Bedroom_Blinds[i15d25d50901049b6aea49b488d5a611c], true);
        }
        for (int i7390902f24444a64acfc7f2eb7602ae4 = 0; i7390902f24444a64acfc7f2eb7602ae4 < 3; i7390902f24444a64acfc7f2eb7602ae4++)
        {
            digitalWrite(house_Bedroom_Blinds[i7390902f24444a64acfc7f2eb7602ae4], house_Kitchen_Lamps);
        }
        for (int i5648e7d91e59482a9cf1d5bd30b20d72 = 0; i5648e7d91e59482a9cf1d5bd30b20d72 < 2; i5648e7d91e59482a9cf1d5bd30b20d72++)
        {
            digitalWrite(house_Kitchen_Lamps[i5648e7d91e59482a9cf1d5bd30b20d72], false);
        }
    }
    
    if (SavedTime == "18:00")
    {
        for (int i4e37bae2fd6b475eaa6776ab1a7bcff8 = 0; i4e37bae2fd6b475eaa6776ab1a7bcff8 < 3; i4e37bae2fd6b475eaa6776ab1a7bcff8++)
        {
            digitalWrite(house_Bedroom_Blinds[i4e37bae2fd6b475eaa6776ab1a7bcff8], false);
        }
        int bob = 0;
        int val = 5;
        float bobjens = 50.25 * 32 * -1.4;
        DetVirkerIkke(val);        
        DetVirkerIkke(bob);        
        float bobbobbob = CelciusToFahrenheit(bob);
        if (val == 1)
        {
            bob = 88;
        }
        else if (val == 2)
        {
            if (true)
            {
            }
        }
        else if (val == 5)
        {
            bob = bob + val;
        }
        else
        {
            val = val + val;
        }
    }
    
}

float CelciusToFahrenheit(int temp)
{
    float result = temp * 1.8 + 32;
    String weekday = "MONDAY";
    String test = "DECEMBER";
    int anothertest = 89;
    int bob = 4;
    int i = 5;
    for (i = 0;i < 10;i = i + 1)    
    {
        int jens = (5 + 5) * 8;
    }
    for (int j = 0;j < 10;j = j + 1)    
    {
        bool alec = true;
        bool magnus = false;
        bool party = (alec || magnus) && digitalRead(6);
    }
    for (int ia65d06d2beaf469481fada1eb36ff0c5 = 0; ia65d06d2beaf469481fada1eb36ff0c5 < 158; ia65d06d2beaf469481fada1eb36ff0c5++)
    {
    }
    for (int id1897fe1a0a74f548037084f5d799586 = 0; id1897fe1a0a74f548037084f5d799586 < bob; id1897fe1a0a74f548037084f5d799586++)
    {
    }
    while (i > 15)
    {
    }
    return result;
}
void DetVirkerIkke(int lol)
{
    int ajens = lol;
}
