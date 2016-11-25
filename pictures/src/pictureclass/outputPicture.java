package pictureclass;

/**
 * Created by Kaitlyn on 11/25/2016.
 */
public class outputPicture{
    public String getImage(String scene){
        switch(scene){
            case "title":
              return "crystal_cavescene.png";

            case "knight scene one male":
                return "castle_male.png";

            case "knight scene one female":
                return "castle_female.png";

            case "knight cave scene male":
                return "cave_with_CD_male.png";

            case "knight cave scene female":
                return "cave_with_WD_female.png";

            case "cave with fae":
                return "crystal_cavescene_fae.png";

            case "dying tree scene":
                return "darkscenetree_fae.png";

            case "healthy tree scene":
                return "lightscenetree_fae.png";

            default:
                return null;
        }
    }

}
