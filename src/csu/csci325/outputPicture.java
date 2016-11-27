package csu.csci325;

/**
 * Created by Kaitlyn on 11/25/2016.
 */
public class outputPicture {
    public static String getImage(String scene){
        switch(scene){
            case "title":
                return "pictures/castle_title-01.png";

            case "game over":
                return "pictures/cave_gameEnd-01.png";

            case "crystal cave":
              return "pictures/crystal_cavescene.png";

            case "knight scene one male":
                return "pictures/castle_male.png";

            case "knight scene one female":
                return "pictures/castle_female.png";

            case "knight cave scene male":
                return "pictures/cave_with_CD_male.png";

            case "knight cave scene female":
                return "pictures/cave_with_WD_female.png";

            case "cave with fae":
                return "pictures/crystal_cavescene_fae.png";

            case "dying tree scene":
                return "pictures/darkscenetree_fae.png";

            case "healthy tree scene":
                return "pictures/lightscenetree_fae.png";

            case "castle beginning":
                return "pictures/castle_begin-01.png";

            default:
                return null;
        }
    }

}
