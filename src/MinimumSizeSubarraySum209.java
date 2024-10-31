public class MinimumSizeSubarraySum209 {
    /* 209. Minimum Size Subarray Sum
     * Medium
     * 
     * Given an array of positive integers nums and a positive integer target, return the
     * minimal length of a subarray whose sum is greater than or equal to target. If there is no
     * such subarray, return 0 instead.
     * 
     * Example 1:
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     * 
     * Example 2:
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     * 
     * Example 3:
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     * 
     * Constraints:
     * - 1 <= target <= 10^9
     * - 1 <= nums.length <= 10^5
     * - 1 <= nums[i] <= 10^4
     * 
     * Follow up: If you have figured out the O(n) solution, try coding another solution of
     * which the time complexity is O(n log(n)).
     * ________________________________________________________________________________________________________
     * 
     * โจทย์นี้ให้หาความยาวขั้นต่ำของ subarray (ชุดของตัวเลขย่อยที่อยู่ติดกันในอาร์เรย์) ที่มีผลรวมมากกว่าหรือ
     * เท่ากับค่าที่กำหนด (target) โดยที่:
     * - ถ้าในอาร์เรย์ nums มี subarray ที่ผลรวมมากกว่าหรือเท่ากับ target ให้ return ความยาวของ subarray
     *   นั้นที่สั้นที่สุด
     * - ถ้าไม่มี subarray ใดที่ผลรวมมากกว่าหรือเท่ากับ target เลย ให้ return 0
     * ข้อกำหนดของโจทย์
     * - อาร์เรย์ nums จะมีค่าเป็นจำนวนเต็มบวกทั้งหมด ซึ่งหมายความว่าผลรวมจะเพิ่มขึ้นเรื่อย ๆ เมื่อขยาย
     *   subarray ให้ยาวขึ้น
     * - ค่า target เป็นจำนวนเต็มบวกเช่นกัน
     * ตัวอย่าง
     * 1. ถ้า nums = [2,3,1,2,4,3] และ target = 7
     * - subarray [4,3] มีผลรวมเท่ากับ 7 และความยาวเป็น 2 ซึ่งเป็น subarray ที่สั้นที่สุดที่มีผลรวมเท่ากับ
     *   7 ดังนั้นผลลัพธ์คือ 2
     * 2. ถ้า nums = [1,4,4] และ target = 4
     * - subarray [4] มีผลรวมเท่ากับ 4 และความยาวเป็น 1 ซึ่งเป็น subarray ที่สั้นที่สุดที่มีผลรวมเท่ากับ
     *   หรือมากกว่า 4 ดังนั้นผลลัพธ์คือ 1
     * 3. ถ้า nums = [1,1,1,1,1,1,1,1] และ target = 11
     * - ในกรณีนี้ ไม่มี subarray ใดที่ผลรวมมากกว่าหรือเท่ากับ 11 ดังนั้นให้ return 0
     * แนวทางในการแก้ปัญหา
     * - สามารถใช้วิธี sliding window เพื่อหา subarray ที่ผลรวมเท่ากับหรือมากกว่าค่า target โดยเพิ่มตัวเลข
     *   ทางขวาและลดตัวเลขทางซ้ายตามความเหมาะสม
     * - เมื่อผลรวมของ subarray มากกว่าหรือเท่ากับ target แล้ว ให้พยายามลดขนาด subarray ลงเพื่อตรวจ
     *   สอบว่าขนาดที่สั้นลงยังคงได้ผลรวมที่ต้องการ
     * ________________________________________________________________________________________________________
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int l = 0, r = 0; r < nums.length; ++r) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    /* โค้ดนี้เป็นการหาความยาวขั้นต่ำของ subarray ที่ผลรวมมากกว่าหรือเท่ากับค่า target โดยใช้เทคนิค sliding
     * window ซึ่งทำงานโดยใช้ตัวชี้สองตัว (l และ r) เพื่อควบคุมขนาดของหน้าต่างย่อยในอาร์เรย์ nums โค้ดนี้มี
     * รายละเอียดดังนี้:
     * 
     * 1. การกำหนดค่าเริ่มต้น:
     * - ans ถูกกำหนดให้เป็น Integer.MAX_VALUE ซึ่งเป็นตัวแทนของค่าความยาว subarray ที่สั้นที่สุดที่
     *   กำลังค้นหา หากไม่พบ subarray ใดเลย ans จะคงค่า Integer.MAX_VALUE และโค้ดจะคืนค่า 0 ใน
     *   ภายหลัง
     * - sum เก็บผลรวมของ subarray ที่กำลังตรวจสอบ (ซึ่งอยู่ระหว่างตัวชี้ l และ r)
     * 
     * 2. ใช้ลูป for ในการขยายหน้าต่างย่อย:
     * - ตัวแปร r ทำหน้าที่เป็นขอบขวาของหน้าต่าง subarray โดยเริ่มจากตำแหน่งแรก (index 0) และ
     *   เคลื่อนที่ไปทางขวาจนถึงจุดสิ้นสุดของอาร์เรย์ nums
     * - ทุกครั้งที่เพิ่มค่า r ก็จะเพิ่มค่า nums[r] เข้าไปใน sum เพื่อให้ผลรวมของ subarray ปัจจุบันอัปเดต
     *   อยู่เสมอ
     * 
     * 3. ตรวจสอบว่า sum >= target:
     * - เมื่อ sum มีค่ามากกว่าหรือเท่ากับ target แสดงว่า subarray ปัจจุบัน (จาก l ถึง r) มีผลรวมตาม
     *   ที่ต้องการ
     * - ใช้ ans = Math.min(ans, r - l + 1) เพื่ออัปเดตความยาวที่สั้นที่สุดของ subarray ที่เจอ โดย r
     *   - l + 1 คือความยาวของ subarray ที่ตรวจสอบอยู่
     * - จากนั้นจะลดขนาดของ subarray ลง โดยการลบ nums[l] ออกจาก sum แล้วเลื่อน l ไปข้างหน้า
     *   เพื่อพยายามหาความยาวที่สั้นลงที่ยังคงมีผลรวมที่ต้องการ
     * 
     * 4. คืนค่า ans:
     * - เมื่อออกจากลูปทั้งหมดแล้ว โค้ดจะคืนค่าของ ans ถ้าค่า ans ยังคงเป็น Integer.MAX_VALUE แปล
     *   ว่าไม่มี subarray ใดที่ผลรวมมากกว่าหรือเท่ากับ target จึงคืนค่า 0
     * - มิฉะนั้น คืนค่าความยาวของ subarray ที่สั้นที่สุดที่มีผลรวมตามต้องการ
     */
}
