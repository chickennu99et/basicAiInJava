package tasks.MathStuffs;
//special math functions
public class SM {
    public static void main(String[] args) {
        System.out.println("Initialized Special Math class");
    }
    
    //relu for all main number types
    public static int relu(int valueIn){
        return(Math.max(0,valueIn));
    }
    public static double relu(double valueIn){
        return(Math.max(0,valueIn));
    }
    public static float relu(float valueIn){
        return(Math.max(0,valueIn));
    }
    
    
    
    //sigmoid for all main number types
    public static int sigmoid(int valueIn){
        return( (int) (1/Math.pow(Math.E, -valueIn)) );
    }
    public static double sigmoid(double valueIn){
        return( (double) (1/Math.pow(Math.E, -valueIn)) );
    }
    public static float sigmoid(float valueIn){
        return( (float) (1/Math.pow(Math.E, -valueIn)) );
    }
    
    
    
    //sigmoid_derivative for all main number types
    public static int sigmoid_derivative(int valueIn){
        int TempVarSD = sigmoid(valueIn);
        return(TempVarSD * (1 - TempVarSD));
    }
    public static double sigmoid_derivative(double valueIn){
        double TempVarSD = sigmoid(valueIn);
        return(TempVarSD * (1 - TempVarSD));
    }
    public static float sigmoid_derivative(float valueIn){
        float TempVarSD = sigmoid(valueIn);
        return(TempVarSD * (1 - TempVarSD));
    }
    
    public static int tanh(int valueIn){
        double EPlus = Math.pow(Math.E, valueIn);
        double EMinus = Math.pow(Math.E, -valueIn);
        return((int)((EPlus-EMinus)/(EPlus+EMinus)));
    }
    public static double tanh(double valueIn){
        double EPlus = Math.pow(Math.E, valueIn);
        double EMinus = Math.pow(Math.E, -valueIn);
        return((EPlus-EMinus)/(EPlus+EMinus));
    }
    public static float tanh(float valueIn){
        float EPlus = (float) Math.pow(Math.E, valueIn);
        float EMinus = (float) Math.pow(Math.E, -valueIn);
        return((float)((EPlus-EMinus)/(EPlus+EMinus)));
    }
    
    public static int tanh_derivative(int valueIn){
        return(1-(int)Math.pow(tanh(valueIn),2));
    }
    public static double tanh_derivative(double valueIn){
        return(1-(double)Math.pow(tanh(valueIn),2));
    }
    public static float tanh_derivative(float valueIn){
        return(1-(float)Math.pow(tanh(valueIn),2));
    }
}