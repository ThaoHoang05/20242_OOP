package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import hust.soict.hedspi.aims.media.Media;
public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison == 0) {
            return Float.compare(m2.getCost(), m1.getCost()); // Higher cost first
        }
        return titleComparison;
    }
}
