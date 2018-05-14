
void setup()
{
    pinMode(8, INPUT);
    pinMode(13, OUTPUT);
}

void loop()
{
    if (digitalRead(8) == true)
    {
        digitalWrite(13, !digitalRead(13));
    }
    
}

