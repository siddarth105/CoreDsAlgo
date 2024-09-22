package Sample;

import java.util.*;

public class Tesco {

    /*Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.
    In a store, a colleague can work for multiple departments.
    For eg. Here are shifts of a colleague in various departments:

    In Bakery department: From 8 to 10
    In Checkout department: From 10 to 12
    In Dairy department: From 14 to 19

    Given the above split of shifts, provide an API/method to return
    the different shifts of a colleague for the day after merging contiguous shifts.
    This will be exposed to the colleague in different UI and help them plan their day accordingly.
    His shift timings in this case are 8 to 12 and 14 to 19.*/


    /*
    1.STEP -> Sort based on from Time
    2.STEP -> Compare the elements

    [8, 9]  -> 0
    [10, 12] -> 1
    [14, 19] -> 2
    [19, 20] -> 3
    [20, 21] -> 4
    [23, 23:20]
    [23:30, 23:50]

    e[i].value - e[i+1].key < 0   -> do not merge
    else -> merge(i, i+1), i++ */

    /*
        i =0, j = i+1
        while (i < j) {
           NOT MERGE
           while (e[i].value - e[j].key < 0) {
                i++, j++
           }
           MERGE
           while (e[i].value - e[j].key >= 0) {
                i++, j++
           }
           i++, j++
        }
    */
    public static List<ShiftTime> mergeShift(List<ShiftTime> inputList) throws Exception {

        if (null != inputList || !inputList.isEmpty()) {
            Collections.sort(inputList, new Comparator<ShiftTime>() {
                @Override
                public int compare(ShiftTime shiftTime1, ShiftTime shiftTime2) {
                    return shiftTime1.getFrom().compareTo(shiftTime2.getFrom());
                }
            });

            int i=0, j=i+1;
            List<ShiftTime> outputList = new ArrayList<>();
            while (i < j) {
                //NOT MERGE
                while (j < inputList.size() && inputList.get(i).getTo().before(inputList.get(j).getFrom())) {
                    outputList.add(inputList.get(i));
                    i++;j++;
                }
                if (i == inputList.size()-1) {
                    outputList.add(new ShiftTime(inputList.get(i).getFrom(), inputList.get(i).getTo()));
                    break;
                }

                //MERGE
                ShiftTime shiftTime = new ShiftTime();
                shiftTime.setFrom(inputList.get(i).getFrom());
                while (j < inputList.size() &&
                        (inputList.get(i).getTo().after(inputList.get(j).getFrom())
                        ||  inputList.get(i).getTo().equals(inputList.get(j).getFrom()))) {
                    i++;j++;
                }
                shiftTime.setTo(inputList.get(i).getTo());
                outputList.add(shiftTime);
                if (i == inputList.size()-1) {
                    break;
                }
                i++; j++;
            }
            return outputList;

        } else {
            throw new Exception();
        }
    }


    public static void main(String[] args) {

        List<ShiftTime> inputList = new ArrayList<>();

        int[][] testData = {{8, 9}, {10, 12}, {14, 19}, {19, 21}, {20, 21}, {22, 23}};

        for (int[] data : testData) {
            // Assuming data format is [startHour, endHour (exclusive)]
            int startHour = data[0];
            int endHour = data[1];

            Calendar startCal = Calendar.getInstance();
            startCal.set(Calendar.HOUR_OF_DAY, startHour);
            startCal.set(Calendar.MINUTE, 0);
            startCal.set(Calendar.SECOND, 0);
            startCal.set(Calendar.MILLISECOND, 0);
            Date from = startCal.getTime();

            Calendar endCal = Calendar.getInstance();
            endCal.set(Calendar.HOUR_OF_DAY, endHour);
            endCal.set(Calendar.MINUTE, 0);
            endCal.set(Calendar.SECOND, 0);
            endCal.set(Calendar.MILLISECOND, 0);

            if (endHour < startHour) {
                endCal.add(Calendar.DAY_OF_MONTH, 1);
            }

            Date to = endCal.getTime();
            ShiftTime shiftTime = new ShiftTime(from, to);
            inputList.add(shiftTime);
        }

        System.out.println("InputList");
        printList(inputList);

        try {
            System.out.println("OutputList");
            List<ShiftTime> outputList = mergeShift(inputList);
            printList(outputList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static void printList(List<ShiftTime> inputList) {
        for (ShiftTime shiftTime : inputList) {
            StringBuilder sb = new StringBuilder();
            if (shiftTime.getFrom() != null) {
                sb.append(shiftTime.getFrom().getHours());
            }
            if (shiftTime.getTo() != null) {
                sb.append(" -> " + shiftTime.getTo().getHours() + "\n");
            }
            System.out.print(sb.toString());
        }
    }


    public static class ShiftTime {
        private Date from;
        private Date to;

        public Date getFrom() {
            return from;
        }

        public Date getTo() {
            return to;
        }

        public ShiftTime() {
        }

        public ShiftTime(Date from, Date to) {
            this.from = from;
            this.to = to;
        }

        public void setFrom(Date from) {
            this.from = from;
        }

        public void setTo(Date to) {
            this.to = to;
        }
    }
}
