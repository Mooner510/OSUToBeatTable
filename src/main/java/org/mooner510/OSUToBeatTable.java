package org.mooner510;

public class OSUToBeatTable {

    private static final String from = "C:\\Users\\DSM2022\\Desktop\\Projects\\Java\\OSUToBeatTable\\src\\main\\resources\\osu.txt";

    private static final String to = "C:\\Users\\DSM2022\\Desktop\\Projects\\QSS\\Unity\\NoteBeat\\NewBuild\\BeatTable_Data\\Resources\\Sub\\UsagiFlap";
    private static final String toFile = "map-Hard.json";

    public static void main(String[] args) {
        new FileExecutor(from, to + "\\" + toFile, 13);
    }
}
