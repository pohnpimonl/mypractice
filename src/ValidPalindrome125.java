public class ValidPalindrome125 {
    /* 125. Valid Palindrome
     * Easy
     * 
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
     * and removing all non-alphanumeric characters, it reads the same forward and backward. 
     * Alphanumeric characters include letters and numbers.
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * 
     * Example 1:
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * 
     * Example 2:
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * 
     * Example 3:
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     * 
     * Constraints:
     * - 1 <= s.length <= 2 * 105
     * - s consists only of printable ASCII characters.
     * ____________________________________________________________________________________________________________
     * 
     * โจทย์นี้ให้เขียนฟังก์ชันที่รับสตริง (string) หนึ่งตัวเป็น input และตรวจสอบว่าสตริงนั้นเป็น palindrome หรือไม่ โดย:
     * 1. แปลงตัวอักษรใหญ่ทั้งหมดให้เป็นตัวอักษรเล็ก เพื่อให้ไม่ต้องสนใจตัวพิมพ์ใหญ่และพิมพ์เล็ก เช่น ถ้าเจอ A ก็ให้แปลงเป็น a เป็นต้น
     * 2. ลบตัวอักษรที่ไม่ใช่ตัวอักษรหรือตัวเลขออกไป ซึ่งหมายถึงให้คงไว้เฉพาะตัวอักษร (A-Z, a-z) และตัวเลข (0-9) เท่านั้น
     * 3. เช็คว่าข้อความที่เหลืออยู่สามารถอ่านจากซ้ายไปขวาแล้วเหมือนกันกับอ่านจากขวาไปซ้ายหรือไม่ ถ้าเหมือนกันแปลว่าเป็น palindrome 
     *    ก็ให้ return true ถ้าไม่เหมือนก็ให้ return false
     * 
     * ตัวอย่าง
     * - กำหนดให้ s = "A man, a plan, a canal: Panama" หลังจากทำตามขั้นตอนข้างต้น สตริงที่เหลือจะเป็น "amanaplanacanalpanama"
     *   ซึ่งอ่านจากซ้ายไปขวาและขวาไปซ้ายได้เหมือนกัน ดังนั้นจึงเป็น palindrome และควร return true
     * - ถ้า s = "race a car" สตริงที่เหลือจะเป็น "raceacar" ซึ่งอ่านจากซ้ายไปขวาและขวาไปซ้ายไม่เหมือนกัน จึงไม่เป็น palindrome 
     *   และควร return false
     * 
     *   เป้าหมายของโจทย์นี้ คือการตรวจสอบว่าคำหรือประโยคที่ให้มาสามารถเป็น palindrome ได้หรือไม่โดยไม่สนใจตัวอักษรพิมพ์ใหญ่และพิมพ์เล็ก
     *   และไม่สนใจสัญลักษณ์พิเศษต่าง ๆ
     * ____________________________________________________________________________________________________________
     */
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                ++l;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                --r;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
    /* โค้ดนี้เป็นการตรวจสอบว่าสตริง ss เป็น palindrome หรือไม่ โดยใช้วิธีการตรวจสอบจากทั้งสองฝั่งพร้อมกัน คือ
     * ฝั่งซ้าย (left) และฝั่งขวา (right) ซึ่งมีรายละเอียดดังนี้:
     * 
     * 1. กำหนดตำแหน่งเริ่มต้นฝั่งซ้ายและฝั่งขวา:
     * - ตัวแปร l (left) เริ่มจากตำแหน่งเริ่มต้นของสตริง (index 0)
     * - ตัวแปร r (right) เริ่มจากตำแหน่งสุดท้ายของสตริง (index s.length() - 1)
     * 
     * 2. วนลูปตรวจสอบเงื่อนไข (while (l < r))
     * - โค้ดจะทำงานในลูป while ตราบใดที่ l น้อยกว่า r นั่นคือจะตรวจสอบจากตำแหน่งซ้ายสุดไป
     *   จนถึงตรงกลางสตริงเท่านั้น โดยเปรียบเทียบตัวอักษรจากทั้งสองฝั่งเข้าหากัน
     * 
     * 3. ข้ามตัวอักษรที่ไม่ใช่ตัวอักษรหรือตัวเลข:
     * - while (l < r && !Character.isLetterOrDigit(s.charAt(l))) ++l;
     *   หากตัวอักษรที่ตำแหน่ง l ไม่ใช่ตัวอักษรหรือเลข จะเพิ่มค่า l ไปตำแหน่งถัดไป เพื่อเลื่อนไปหาตัว
     *   อักษรหรือตัวเลข
     * - while (l < r && !Character.isLetterOrDigit(s.charAt(r))) --r;
     *   เช่นเดียวกัน ถ้าตัวอักษรที่ตำแหน่ง r ไม่ใช่ตัวอักษรหรือตัวเลข จะลดค่า r ไปตำแหน่งก่อนหน้า
     * 
     * 4. เปรียบเทียบตัวอักษรในตำแหน่ง l และ r:
     * - ใช้ Character.toLowerCase ในการแปลงตัวอักษรทั้งสองตำแหน่งให้เป็นตัวพิมพ์เล็กเพื่อไม่สนใจ
     *   ความแตกต่างระหว่างพิมพ์ใหญ่และพิมพ์เล็ก
     * - ถ้าตัวอักษรที่ตำแหน่ง l และ r ไม่ตรงกัน (!=) ฟังก์ชันจะ return false ทันที เนื่องจากสตริงไม่
     *   เป็น palindrome
     * - ถ้าตัวอักษรตรงกัน จะเพิ่มค่า l และลดค่า r เพื่อไปตรวจสอบคู่ถัดไป
     * 
     * 5. สตริงผ่านการตรวจสอบทั้งหมดและเป็น palindrome:
     * - เมื่อวนลูปเสร็จ (ทุกตัวอักษรจากทั้งสองฝั่งตรงกันหมด) โค้ดจะ return true
     */
}
