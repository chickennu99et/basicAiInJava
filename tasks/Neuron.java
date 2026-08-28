package tasks;
public class Neuron
{
    private double biasA;
    private double biasB;
    private double[] weightsA;
    private double[] weightsB;
    private final int length;
    
    public Neuron(int connectionCount, double biasInA, double biasInB) 
    {
        weightsA = new double[connectionCount];
        weightsB = new double[connectionCount];
        for(int i = 0; i<connectionCount; i++)
        {
            weightsA[i] = Math.random()*2-1;
            weightsB[i] = Math.random()*2-1;
        }
        biasA = biasInA;
        biasB = biasInB;
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
        return(a*(b/(Math.exp(-b))));
    }
}
