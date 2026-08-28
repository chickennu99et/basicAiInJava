package tasks;
import tasks.Layer;
public class Network {
    
    private Layer[] layers;
    private double learnRate;
    private double regRate;
    private final int layerCount;
    private final int[] layersAndTheirNeuronCount;
    private final int valuesIn;
    
    public Network(int[] layersNNeurons, int valuesInn, double learnRate, double regRate)
    {
        valuesIn = valuesInn;
        layerCount = layersNNeurons.length;
        learnRate = learnRate;
        regRate = regRate;
        layers = new Layer[layerCount];
        layersAndTheirNeuronCount = layersNNeurons.clone();
        layers[0] = new Layer(layersNNeurons[0], valuesIn, learnRate, regRate);
        for(int i = 1; i<layerCount; i++)
        {
            layers[i] = new Layer(layersNNeurons[i], layersNNeurons[i-1], learnRate, regRate);
        }
    }
    public Network(int layer, int ValuesInn, int neuronsPerLayer, int NeuronsOut, double learnRate, double regRate)
    {
        valuesIn = ValuesInn;
        layerCount = layer;
        learnRate = learnRate;
        regRate = regRate;
        layers = new Layer[layerCount];
        layers[0] = new Layer(neuronsPerLayer, valuesIn, learnRate, regRate);
        for(int i = 1; i<layerCount-1; i++)
        {
            layers[i]=new Layer(neuronsPerLayer, neuronsPerLayer, learnRate, regRate);
        }
        layers[layerCount-1] = new Layer(NeuronsOut, neuronsPerLayer, learnRate, regRate);
        layersAndTheirNeuronCount = new int[layer];
        for(int i = 0; i<layerCount; i++)
        {
            layersAndTheirNeuronCount[i] = layers[i].getOutputCount();
        }
    }
    
    public int[] getLATNC(){
        return(layersAndTheirNeuronCount);
    }
     
    public double[] calculateOutputs(double[] valuesIn)
    {
        double[] returnValues = valuesIn.clone();
        for(int i = 0; i<layerCount; i++)
        {
            returnValues = layers[i].calculateOutputs(returnValues);
        }
        return(returnValues);
    }
    
    public void calcOutAndPrint(double[] valuesIn)
    {
        double[] returnValues = valuesIn.clone();
        for(int i = 0; i<layerCount; i++)
        {
            returnValues = layers[i].calculateOutputs(returnValues);
        }
        for(int i = 0;i<returnValues.length;i++)
        {
            System.out.println(returnValues[i]);
        }
        System.out.println("");
    }
    public String getNeuronValuesAt(int layerAt, int NeuronNumberDesired)
    {
        return(layers[layerAt].getNeuronWeightsAt(NeuronNumberDesired));
    }
    public void updateRegRate(double updatedRegRate)
    {
        regRate = updatedRegRate;
        for(int i = 0; i<layerCount; i++)
        {
            layers[i].updateRegRate(updatedRegRate);
        }
        System.out.println("e");
    }
    public int valuesIn()
    {
        return(valuesIn);
    }
    public void updateLearnRate(double updatedLearnRate)
    {
        learnRate = updatedLearnRate;
        for(int i = 0; i<layerCount; i++)
        {
            layers[i].updateLearnRate(updatedLearnRate);
        }
        System.out.println("e");
    }
}
