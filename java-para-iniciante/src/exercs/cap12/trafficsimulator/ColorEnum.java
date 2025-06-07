package exercs.cap12.trafficsimulator;

enum ColorEnum {

        RED(8000), GREEN(8000), YELLOW(3000);

        int delay;

        ColorEnum(int delay) {
            this.delay = delay;
        }


}
