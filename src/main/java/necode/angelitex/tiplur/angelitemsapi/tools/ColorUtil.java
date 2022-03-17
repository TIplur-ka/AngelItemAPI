package necode.angelitex.tiplur.angelitemsapi.tools;


import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtil {
    /**
     * Created by TIplur 18.12.2020
     */
    public ColorUtil() {}

    /**
     * @param string Your string for hex color formatting
     */
    public static String setHexColor(String string) {
        Pattern hexPattern = Pattern.compile("<#>" + "([A-Fa-f0-9]{6})" + "Ю");
        Matcher matcher = hexPattern.matcher(string);
        StringBuffer buffer = new StringBuffer(string.length() + 32);

        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, "§x§" + group.charAt(0) + '§' + group.charAt(1) + '§' + group.charAt(2) + '§' + group.charAt(3) + '§' + group.charAt(4) + '§' + group.charAt(5));
        }

        return matcher.appendTail(buffer).toString();
    }

    /**
     * @param string Your string for normal color formatting
     */
    public static String setColor(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    /**
     *
     */
    public static String MultiCollor(String s) {
        return StringEscapeUtils.unescapeJava(
                org.bukkit.ChatColor.translateAlternateColorCodes('&',
                        s.replaceAll("&#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])", "&x&$1&$2&$3&$4&$5&$6")
                ));
    }
}
