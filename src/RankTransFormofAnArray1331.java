import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * 
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * 
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output: [5,3,4,2,8,6,7,1,3]
 */

public class RankTransFormofAnArray1331 {
    public static int[] arrayRankTransform(int[] arr) {
        //1. clone array โจทย์
        int[] clonearr = arr.clone();
        //2. sort array ที่ clone
        Arrays.sort(clonearr);
        //3. สร้าง map เพิ่อเก็บข้อมูล rank
        Map<Integer,Integer> rank = new HashMap<>();
        //4. for Array ที่ sort ใส่ข้อมูลลงใน map
        //   โดย key = ค่าใน Array ที่เรียงแล้ว
        //       Value = Size ของ Array + 1 ไปเรื่อยๆ
        for (int i : clonearr) {
            rank.putIfAbsent(i, rank.size()+1);
        }
        //5. เอา Array โจทย์ มาเทียบ key และ ใส่ Value ใหม่ ลงไป 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
            System.out.println(arr[i]);
        }
        return arr;
    }
}
