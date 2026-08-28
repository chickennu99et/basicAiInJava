package tasks;
import tasks.Neuron;
public class Layer 
{
    private Neuron[] Neurons;
    private final int neuronsIntoLayer;
    private final int neuronsInCurrentLayer;
    private double learnRate;
    private double regRate;
    
    public Layer(int neuronCount, int priorLayersNeurons, double learnRate, double regRate)
    {
        learnRate = learnRate;
        regRate = regRate;
        Neurons = new Neuron[neuronCount];
        neuronsInCurrentLayer = neuronCount;
        neuronsIntoLayer = priorLayersNeurons;
        for(int i = 0; i<neuronCount; i++)
        {
            Neurons[i] = new Neuron(neuronsIntoLayer, learnRate, regRate);
        }
    }
    
    public double[] calculateOutputs(double[] valuesIn)
    {
        if(valuesIn.length!=Neurons[0].getConnectionCount())
        {
            System.out.println("Error, incorrect amount of values in, skipping layer");
            return(valuesIn);
        }
        
        
        
        double[] returnValues = new double[neuronsInCurrentLayer];
        
        for(int i = 0; i<neuronsInCurrentLayer; i++)
        {
            returnValues[i] = Neurons[i].calculateOutput(valuesIn);
        }
        return(returnValues);
    }
    
    public int getOutputCount()
    {
        return(neuronsInCurrentLayer);
    }
    
    public String getNeuronWeightsAt(int NeuronNumX)
    {
        return(Neurons[NeuronNumX].getValues());
    }
    public void updateRegRate(double updatedRegRate)
    {
        regRate = updatedRegRate;
        for(int i = 0; i<neuronsInCurrentLayer; i++)
        {
            Neurons[i].updateRegRate(updatedRegRate);
        }
    }
    public void updateLearnRate(double updatedLearnRate)
    {
        learnRate = updatedLearnRate;
        for(int i = 0; i<neuronsInCurrentLayer; i++)
        {
            Neurons[i].updateLearnRate(updatedLearnRate);
        }
    }
}
