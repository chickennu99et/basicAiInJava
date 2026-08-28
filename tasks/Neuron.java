package tasks;
public class Neuron
{
    private double[] weightsA;
    private double[] weightsB;
    private double biasA;
    private double biasB;
    private final int length;
    private double learnRate;
    private double regRate;
    
    public Neuron(int connectionCount, double learnRate, double regRate, boolean notOldLoad) 
    {
        learnRate = learnRate;
        regRate = regRate;
        weightsA = new double[connectionCount];
        weightsB = new double[connectionCount];
        biasA = Math.random()*2-1;
        biasB = Math.random()*2-1;
        if(notOldLoad){
            for(int i = 0; i<connectionCount; i++)
            {
                weightsA[i] = Math.random()*2-1;
                weightsB[i] = Math.random()*2-1;
                biasA = Math.random()*2-1;
                biasB = Math.random()*2-1;
            }
        }
        else
        {
            biasA = 0.0;
            biasB = 0.0;
        }
        length = connectionCount;
    }
    
    public double calculateOutput(double[] inputs)
    {
        double a = biasA;
        double b = biasB;
        for(int i = 0; i<length; i++){
            a+=weightsA[i]*inputs[i];
            b+=weightsB[i]*inputs[i];
        }
        return(a/(1.0+Math.exp(-a))*b);
    }
    
    public int getConnectionCount(){
        return(length);
    }
    public String getValues()
    {
        String returnValue = "";
        for(int i = 0; i<length; i++)
        {
            returnValue+=weightsA[i] + "," + weightsB[i]+ ",";
        }
        returnValue += biasA + "," + biasB;
        return(returnValue);
    }
    public void updateRegRate(double updatedRegRate)
    {
        regRate = updatedRegRate;
    }
    public void updateLearnRate(double updatedLearnRate)
    {
        learnRate = updatedLearnRate;
    }
}
