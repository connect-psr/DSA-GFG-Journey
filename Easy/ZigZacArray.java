public class ZigZacArray{
    public static void interleaved(char[] s1, char s2[], char s3[], int len1, int len2){
        if(s1 == null || s1.length <= 0  && s2 == null || s2.length <= 0){
            return;
        }

        int k = 0, i = 0, j = 0;
        while(i < s1.length && j < s2.length){
            s3[k++] = s1[i++];
            s3[k++] = s2[j++];
            
        }

        while(i < s1.length){
            s3[k] = s2[i++];
        }

        while(j < s2.length){
            s3[k] = s2[j++];
        }

        return;   
    }

    public static void printArr(char []s3){
        for(int i = 0; i < s3.length; ++i){
            System.out.print(s3[i]+" ");
        }
    }
    public static void main(String[]a){
        char []s1 ={'a', 'b', 'c', 'd'};
        char []s2 = {'w', 'x', 'y', 'z'};
        char s3[] = new char[s1.length + s2.length];
        ZigZacArray.interleaved(s1, s2, s3, s1.length, s2.length);
        ZigZacArray.printArr(s3);
    }
}