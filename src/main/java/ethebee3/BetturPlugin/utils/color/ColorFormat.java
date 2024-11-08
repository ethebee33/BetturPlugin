package ethebee3.BetturPlugin.utils.color;

import ethebee3.BetturPlugin.Main;
import ethebee3.BetturPlugin.utils.color.ColorConfig;
import net.md_5.bungee.api.ChatColor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorFormat {


    public static String formatText(String text) {

        String colorsCode = "abcdef0123456789";

        Pattern pattern = getCustomPattern(colorsCode);

        StringBuilder stringBuilder = new StringBuilder();

        Matcher matcher = pattern.matcher(text);

        int lastIndex = 0;

        // '&'
        while (matcher.find()) {

            int startIndex = matcher.start();
            int endIndex = matcher.end();

            // Before color code
            if (startIndex > lastIndex) {
                stringBuilder.append(text.substring(lastIndex, startIndex));
            }
            if (startIndex + 1 < text.length()) {

                // Get color code
                char colorChar = text.charAt(startIndex + 1);

                String colorCode = String.valueOf(colorChar);

                // Get Gradient
                List<String> hexGradient = ColorConfig.getGradient(colorCode);

                // Gradient
                if (hexGradient != null) {
                    // Create Gradient
                    List<ChatColor> gradiant = Gradient.generateGradient(
                            hexGradient.get(0), hexGradient.get(1), endIndex - startIndex - 2
                    );

                    String gradiantPart = formatGradiant(gradiant, text.substring(startIndex + 2, endIndex));

                    stringBuilder.append(gradiantPart);
                }
                else {
                    // Custom colors
                    ChatColor color = ColorConfig.getColor(colorCode);

                    if (color != null) {
                        stringBuilder.append(color)
                                . append(text.substring(startIndex + 2, endIndex));
                    }
                    else { // No colors
                        stringBuilder.append(text.substring(startIndex, endIndex));
                    }
                }
            } // No color character
            else {
                stringBuilder.append(text.substring(lastIndex, endIndex));
            }
            lastIndex = endIndex + 1;
        }

        // End of message
        if (lastIndex < text.length()) {
            stringBuilder.append(text.substring(lastIndex));
        }

        return stringBuilder.toString();
    }

    public static Pattern getCustomPattern(String colorsCode) {
        // "&[c].*?(?=&[b]|$)"
        // '&c ... to ... &b or end' (for example)
        return Pattern.compile("&[" + colorsCode + "].*?(?=&[" + colorsCode + "]|$)");
    }

    public static String formatGradiant(List<ChatColor> gradiant, String part) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < part.length(); i++) {

            char c = part.charAt(i);
            stringBuilder.append("" + gradiant.get(i) + c);
        }
        return stringBuilder.toString();
    }


}