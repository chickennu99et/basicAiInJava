package tasks;
import tasks.Neuron;

public class layer 
{
    private Neuron[] neurons;
    private final int plic;
    private final int nlic;
    //plic = priorLayersInputCount
    //nlic = nextLayersInputCount
    public layer(int count, int plicIn)
    {
        neurons = new Neuron[count];
        for(int i = 0; i<count; i++)
        {
            neurons[i] = new Neuron(plicIn, Math.random()*2-1, Math.random()*2-1);
        }
        plic = plicIn;
        nlic = neurons.length;
    }
    public double[] calculateOutputs(double[] inputs)
    {
        if(inputs.length!=plic)
        {
            System.out.println("ERROR!!! INCORRECT INPUT COUNT");
            return(new double[nlic]);
        }
        double[] outputVars = new double[nlic];
        for(int i = 0; i<nlic; i++)
        {
            outputVars[i] = neurons[i].calculateOutput(inputs);
        }
        return(outputVars);
    }
}
