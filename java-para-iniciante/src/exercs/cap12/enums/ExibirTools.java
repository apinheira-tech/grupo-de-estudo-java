package exercs.cap12.enums;

public class ExibirTools {
    public static void main(String[] args) {
        System.out.println("Constantes da ENUMs Tools");
        for (ToolsEnum tool : ToolsEnum.values()) {
            System.out.println(tool + " - Ordinal " + tool.ordinal());
        }

    }

}
