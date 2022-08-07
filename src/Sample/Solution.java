package Sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {	
	
	public String solution(String S) {
		String[] photos = S.split("\\\\n");
		List<Photo> photoList = new ArrayList<Photo>();	
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Map<String, List<Photo>> cityMap = new HashMap<String, List<Photo>>();
		
		//Parsing	
		for (int i = 0; i < photos.length; i++) {
			String photo = photos[i].substring(0, photos[i].length()-1);
			if (i == photos.length-1) {
				photo = photos[i].substring(0, photos[i].length());
			}			
			String[] element = photo.split(",");
			String city = element[1];
			String name = element[0].substring(0, element[0].length()-4);
			String ext = element[0].substring(element[0].length()-3, element[0].length());
			String date = element[2];
			Date timeTaken = null;
			try {
				timeTaken = format.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Photo photoObj = new Photo(name, ext, city, timeTaken);
			photoList.add(photoObj);
			List<Photo> cityPhotoList = cityMap.get(city);
			if(cityPhotoList == null) {
				cityPhotoList = new ArrayList<Photo>();
				cityPhotoList.add(photoObj);
				cityMap.put(city, cityPhotoList);
			} else {
				cityPhotoList = cityMap.get(city);
				cityPhotoList.add(photoObj);
			}	
		}
		
		cityMap.forEach((city, cityPhotoList) -> {
			Collections.sort(cityPhotoList, new PhotoSortingComparator());
			for(int i=0; i < cityPhotoList.size(); i++) {
				cityPhotoList.get(i).newName = city + (i+1);
			}
		});
		
		System.out.println("AFTER SORT :-");
		String city = "";
		for (Photo photo : photoList) {
			city = city + photo.newName;
			System.out.println(photo.newName + " == " + photo.timeTaken.toString() + " == " + photo.name);
		}
		return city;
	}
	
	static class PhotoSortingComparator implements Comparator<Photo> { 		  
        @Override
        public int compare(Photo photo1, Photo photo2) {  
            return photo1.timeTaken.compareTo(photo2.timeTaken);     
        }
    } 
	
	public static class Photo {
        String name;
        String ext;
        String city;
        String newName;
        Date timeTaken;
		
        public Photo(String name, String ext, String city, Date timeTaken) {
			this.name = name;
			this.ext = ext;
			this.city = city;
			this.timeTaken = timeTaken;
		}

		@Override
		public String toString() {
			return "Photo [name=" + name + ", ext=" + ext + ", city=" + city + ", timeTaken=" + timeTaken + "]";
		}
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();	
		s.solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\\\\njohn.png, London, 2015-06-20 15:13:22\\\\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\\\\nEiffel.jpg, Paris, 2015-07-23 08:03:02\\\\npisatower.jpg, Paris, 2015-07-22 23:59:59\\\\nBOB.jpg, London, 2015-08-05 00:02:03\\\\nnotredame.png, Paris, 2015-09-01 12:00:00\\\\nme.jpg, Warsaw, 2013-09-06 15:40:22\\\\na.png, Warsaw, 2016-02-13 13:33:50\\\\nb.jpg, Warsaw, 2016-01-02 15:12:22\\\\nc.jpg, Warsaw, 2016-01-02 14:34:30\\\\nd.jpg, Warsaw, 2016-01-02 15:15:01\\\\ne.png, Warsaw, 2016-01-02 09:49:09\\\\nf.png, Warsaw, 2016-01-02 10:55:32\\\\ng.jpg, Warsaw, 2016-02-29 22:13:11");
	}
}
