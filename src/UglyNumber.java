public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) return index;
        int[] ugly = new int[index];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for(int i = 1; i < index; ++i) {
            ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            if(ugly[i] == ugly[i2] * 2) i2++;
            if(ugly[i] == ugly[i3] * 3) i3++;
            if(ugly[i] == ugly[i5] * 5) i5++;
        }
        return ugly[index - 1];
    }

    public static void main(String[] args) {
        UglyNumber c = new UglyNumber();
        System.out.println(c.GetUglyNumber_Solution(7));
    }
}

