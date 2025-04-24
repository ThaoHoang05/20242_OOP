package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import hust.soict.hedspi.aims.media.Media;
public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costComparison = Float.compare(m2.getCost(), m1.getCost()); // Higher cost first
        if (costComparison == 0) {
            return m1.getTitle().compareTo(m2.getTitle()); // Alphabetical order
        }
        return costComparison;
    }

}
