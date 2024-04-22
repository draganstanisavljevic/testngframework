package utils;

public class CalculateResolution {

    public static String getResolution(){
        String resolution = System.getProperty("resolution");
        String calculatedResolution;
        switch (resolution == null ? "":resolution) {
            case  "small":
                calculatedResolution =  "--window-size=800,800";
                break;
            case "middle":
                calculatedResolution =  "--window-size=1024,768";
                break;
            default:
                calculatedResolution = "--start-maximized";
                break;
        }
        return calculatedResolution;
    }
}
