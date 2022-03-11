import java.io.File;

/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 02.03.2022
 * \*  ----- group JAVA-27 -----
 * \* Description:
 * \
 */
class MainTest {

    public static boolean createDirectoriesWithCommonParent(File parent, String... subs) {

        parent.mkdirs();
        if (!parent.exists() || !parent.isDirectory()) {
            return false;
        }

        for (String sub : subs) {
            File subFile = new File(parent, sub);
            subFile.mkdir();
            if (!subFile.exists() || !subFile.isDirectory()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        createDirectoriesWithCommonParent(new File("test/foo"), "a", "b", "c");
    }
}
