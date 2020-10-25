package L2;

public class Hm2 {

    public static void main(String[] args){
        int[] numsFor1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] numsFor2 = new int[8];
        int[] numsFor34 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int[][] numsFor5 = new int[4][4];
        int[] numsFor6_1 = { 1, 1, 1, 2, 1 };
        int[] numsFor6_2 = { 2, 1, 1, 2, 1 };
        int[] numsFor7 = { 1, 2, 3, 4, 5, 6 };
        int[] numsFor8 = { 1, 2, 3, 4, 5, 6 };
        int[] numsFor9_1 = { 1, 2, 3, 4, 5, 6 };
        int[] numsFor9_2 = { 1, 2, 3 };
        int[] numsFor9_3 = new int[6];
        int[][] numsFor10_1 = {{1,2},{1,2}};
        int[][] numsFor10_2 = {{1,2},{1,2}};

        for(int i = 0; i < numsFor1.length; i++)
            System.out.print(" " + numsFor1[i]);
        System.out.println();
        invers(numsFor1);
        for(int i = 0; i < numsFor1.length; i++)
            System.out.print(" " + numsFor1[i]);
        System.out.println();
        System.out.println();

        rise(numsFor2);
        for(int i = 0; i < numsFor2.length; i++)
            System.out.print(" " + numsFor2[i]);
        System.out.println();
        System.out.println();

        for(int i = 0; i < numsFor34.length; i++)
            System.out.print(" " + numsFor34[i]);
        System.out.println();
        chooseAndMultypl(numsFor34);
        for(int i = 0; i < numsFor34.length; i++)
            System.out.print(" " + numsFor34[i]);
        System.out.println();
        System.out.println();

        findMaxAndMin(numsFor34);
        System.out.println();

        diag1(numsFor5);
        for(int i = 0; i < numsFor5.length; i++){
            for(int j = 0; j < numsFor5.length; j++)
                System.out.print(" " + numsFor5[i][j]);
            System.out.println();
        }
        System.out.println();

        checkBalance(numsFor6_1);
        checkBalance(numsFor6_2);
        System.out.println();

        moveM(numsFor7, 1);
        for(int i = 0; i < numsFor7.length; i++)
            System.out.print(" " + numsFor7[i]);
        System.out.println();
        moveM1(numsFor8, 2);
        for(int i = 0; i < numsFor8.length; i++)
            System.out.print(" " + numsFor8[i]);
        System.out.println();
        System.out.println();

        numsFor9_3 = choose(numsFor9_1,numsFor9_2);
        for(int i = 0; i < numsFor9_3.length; i++)
            System.out.print(" " + numsFor9_3[i]);
        System.out.println();
        System.out.println();

        findFragment(numsFor10_1,numsFor10_2);
        System.out.println();
        System.out.println();

    }

    public static void invers(int[] nums){
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0) nums[i] = 0;
            else nums[i] = 1;
    }
    public static void rise(int[] nums){
        int a = 1;
        for(int i = 0; i < nums.length; i++){
            nums[i] = a;
            a += 3;
        }
    }
    public static void chooseAndMultypl(int[] nums){
        for(int i = 0; i < nums.length; i++)
            if(nums[i] < 6) nums[i] *= 2;
    }
    public static void findMaxAndMin(int[] nums){
        int min, max;

        min = nums[0];
        max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        System.out.println(min + " " + max);
    }
    public static void diag1(int[][] nums){
        for(int i = 0; i < nums.length; i++)
            for(int j = 0; j < nums.length; j++){
                if(i == j) nums[i][j] = 1;
                if(i + j == nums.length - 1) nums[i][j] = 1;
            }
    }
    public static void checkBalance(int[] nums){
        int sum1, sum2;

        for(int i = 1; i < nums.length; i++){
            sum1 = 0;
            sum2 = 0;
            for(int j = 0; j < i; j++)
                sum1 += nums[j];
            for(int j = i; j < nums.length; j++)
                sum2 += nums[j];
            if(sum1 == sum2) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
    public static void moveM(int[] nums, int n){
        int i, j;
        int[] hlp = new int[nums.length];

        for(i = 0; i < nums.length; i++){
            j = i + n;
            if(j >= nums.length) j -= nums.length;
            else if(j < 0) j += nums.length;
            hlp[j] = nums[i];
        }
        for(i = 0; i < nums.length; i++)
            nums[i] = hlp[i];
    }
    public static void moveM1(int[] nums, int n){
        int i, j, j1, buf1, buf2, start, lth;

        if(nums.length % n != 0){  //выборка не будет бегать по одним и тем же номерам
            j = 0;
            j1 = 0;
            buf1 = nums[0];
            for(i = 0; i < nums.length; i++){
                j1 = j + n;
                if(j1 >= nums.length) j1 -= nums.length;
                else if(j1 < 0) j1 += nums.length;
                buf2 = nums[j1];
                nums[j1] = buf1;
                buf1 = buf2;
                j = j1;
            }
        }
        else{
            start = 0;
            lth = nums.length / n;
            for(start = 0; start < n; start++){  //первые n элементов
                j = start;
                j1 = start;
                buf1 = nums[start];
                for(i = 0; i < lth; i++){  //(nums.length / n) перестановок
                    j1 = j + n;
                    if(j1 >= nums.length) j1 -= nums.length;
                    else if(j1 < 0) j1 += nums.length;
                    buf2 = nums[j1];
                    nums[j1] = buf1;
                    buf1 = buf2;
                    j = j1;
                }
            }
        }
    }
    public static int[] choose(int[] nums1, int[] nums2){
        int i, j;
        int el = 0;
        int[] hlp = new int[nums1.length];

        for(i = 0;i < nums1.length;i++){
            for(j = 0;j < nums2.length;j++)
                if(nums1[i] == nums2[j]) break;
            if(j == nums2.length){
                hlp[el] = nums1[i];
                el++;
            }
        }


        return hlp;
    }
    public static void findFragment(int[][] nums1, int[][] nums2){
        int i = 0, j = 0;
        int dx = 0, dy = 0;  //разница в габаритах
        int startx, starty;  //точка отсчёта сравнения

        if((nums1.length > nums2.length)||(nums1[0].length > nums2[0].length))  //не помещается
            System.out.println("ERROR");
        else{
            dx = nums2.length - nums1.length;
            dy = nums2[0].length - nums1[0].length;
            for(startx = 0;startx < dx;startx++){
                for (starty = 0; starty < dy; starty++){   //взяли точку отсчёта
                    for(i = 0;i < nums1.length;i++){       //сравниваем
                        for (j = 0; j < nums1[0].length; j++){
                            if(nums1[i][j] != nums2[i+startx][j+starty]) break;
                        }
                        if(nums1[i][j] != nums2[i+startx][j+starty]) break;
                    }
                    if((i == nums1.length)&&(j == nums1[0].length)){   //расхождений не обнаружено
                        System.out.println("Array included");
                        return;                                        //заканчиваем
                    }
                }
            }
            System.out.println("Array do not included");               //не нашли

        }

    }

}
