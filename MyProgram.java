import tasks.*;
public class MyProgram
{
    public static void main(String[] args)
    {
        layer newLayer = new layer(16, 16);
        double[] valuesIn = new double[4096];
        for(int i = 0; i<valuesIn.length; i++)
        {
            valuesIn[i] = Math.random()*2-1;
        }
        valuesIn = newLayer.calculateOutputs(valuesIn);
        for(int i = 0; i<16; i++){
            System.out.println(valuesIn[i]);
        }
    }
}
