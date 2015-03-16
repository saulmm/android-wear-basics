package test.com.saulmm.simplenotification.model;

public class Direction {

    private int directionNumber;
    private String directionDescription;
    private int directionImage;

    public Direction(int directionNumber, String directionDescription, int directionImage) {

        this.directionNumber = directionNumber;
        this.directionDescription = directionDescription;
        this.directionImage = directionImage;
    }

    public int getDirectionNumber() {

        return directionNumber;
    }

    public void setDirectionNumber(int directionNumber) {

        this.directionNumber = directionNumber;
    }

    public String getDirectionDescription() {

        return directionDescription;
    }

    public void setDirectionDescription(String directionDescription) {

        this.directionDescription = directionDescription;
    }

    public int getDirectionImage() {

        return directionImage;
    }

    public void setDirectionImage(int directionImage) {

        this.directionImage = directionImage;
    }
}
