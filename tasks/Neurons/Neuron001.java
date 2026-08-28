package tasks.Neurons;

public class Neuron001
{
    private double[] weights;
    private double bias;
    private String returnType;
    
    public Neuron001(int connectionCount) 
    {
        weights = new double[connectionCount]
        for(int i = 0; i<connectionCount; i++)
        {
            weights[i] = Math.random*2-1;
        }
        bias = 1.0;
        returnType = "relu"
    }
    public Neuron001(int connectionCount, double biasIn) 
    {
        weights = new double[connectionCount]
        for(int i = 0; i<connectionCount; i++)
        {
            weights[i] = Math.random*2-1;
        }
        bias = biasIn;
        returnType = "relu"
    }
    public Neuron001(int connectionCount, String returnValIn)
    {
        weights = new double[connectionCount]
        for(int i = 0; i<connectionCount; i++)
        {
            weights[i] = Math.random*2-1;
        }
        bias = 1.0;
        returnType = returnValIn;
    }
    public Neuron001(int connectionCount, double biasIn, String returnValIn) 
    {
        weights = new double[connectionCount]
        for(int i = 0; i<connectionCount; i++)
        {
            weights[i] = Math.random*2-1;
        }
        bias = biasIn;
        returnType = returnValIn;
    }
    
    
    
    public double calculateOutput(double[] inputs)
    {
        if(inputs.length!=weights.length)
        {
            return(null);
        }
        
        double returnVal = bias;
        
        for(int i = i<inputs.length; i++)
        {
            returnVal+=inputs[i]*weights[i];
        }
        if(returnType.equals("relu"))
        {
            return(relu(returnVal));
        }
        else if(returnType.equals("sigmoid"))
        {
            return(sigmoid(returnVal));
        }
        else if(returnType.equals("tanh"))
        {
            return(tanh(returnVal));
        }
        else
        {
            return(null);
        }
    }
}