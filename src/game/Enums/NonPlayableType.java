package game.Enums;

public enum NonPlayableType {
    GRAVEYARD,
    RESPAWNABLE,
    GUST,
    OCEANIC,
    CASTLE,
    ALLY,
    INVADER;

    public static boolean matchEnum(Enum enums){
        for (NonPlayableType nonPlayableType : NonPlayableType.values()){
            if (enums == nonPlayableType){
                return true;
            }
        }
        return false;
    }
}
