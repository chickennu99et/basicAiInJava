package tasks;
import tasks.layer;
public class network {
    private layer[] layers;
    private final int inputCount;
    public network(int layerCount, int neuronsPerLayer){
        layers = new layer[layerCount];
        for(int i = 0; i<layers.length; i++)
        {
            layers[i] = new layer(neuronsPerLayer, neuronsPerLayer);
        }
        inputCount = neuronsPerLayer;
    }
    public double[] calculateTotalOutputs(double[] inputs){
        if(inputs.lenth!=inputCount){
            return(new double[inputCount]);
        }
        double[] currentValues = inputs.clone();
        for(int i = 0; i<layerCount; i++){
            
        }
    }
}
