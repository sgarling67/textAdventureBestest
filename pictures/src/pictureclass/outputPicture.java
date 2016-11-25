package pictureclass;

/**
 * Created by Kaitlyn on 11/25/2016.
 */
public class outputPicture{
    public String getImage(String scene){
        switch(scene){
            case "title":
              return "crystal_cavescene";
            case "knight scene one male":
                return "castle_male";
            case "knight scene one female":
                return "castle_female";
            case "knight cave scene male":
                return "cave_with_CD_male";
            case "knight cave scene female":
                return "cave_with_WD_female";
            case "cave with fae":
                return "crystal_cavescene_fae";
            case "dying tree scene":
                return "darkscenetree_fae";
            case "healthy tree scene":
                return "lightscenetree_fae";

            default:
                return null;
        }
    }

}
