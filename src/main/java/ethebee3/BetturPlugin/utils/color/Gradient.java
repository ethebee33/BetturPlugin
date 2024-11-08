package ethebee3.BetturPlugin.utils.color;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;

import java.util.ArrayList;
import java.util.List;

public class Gradient {
    public static String formatGradient(String message, String color1, String color2) {
        List<ChatColor> gradient = generateGradient(color1, color2, message.length());
        int i = 0;
        String stringBuilder = "";
        for(ChatColor color : gradient) {
            stringBuilder.append("&").append(color).append(message.charAt(i))
            i++;
        }
        return null;
    }

    public static List<ChatColor> generateGradient(String color1, String color2, int length) {

        Color startColor = Color.fromRGB(Integer.parseInt(color1.replace("#", ""), 16));
        Color endColor = Color.fromRGB(Integer.parseInt(color2.replace("#", ""), 16));

        List<ChatColor> gradiant = new ArrayList<>();
        for (int i = 0; i <= length; i++) {

            // Calculer les composantes RGB intermédiaires
            int r = interpolate(startColor.getRed(), endColor.getRed(), i, length);
            int g = interpolate(startColor.getGreen(), endColor.getGreen(), i, length);
            int b = interpolate(startColor.getBlue(), endColor.getBlue(), i, length);

            // Convertir les valeurs RGB en code hexadécimal
            String hexColor = String.format("#%02x%02x%02x", r, g, b);

            // Ajouter la couleur au dégradé
            gradiant.add(ChatColor.of(Utils.hexToRgb(hexColor)));
        }
        return gradiant;
    }

    public static int interpolate(int start, int end, int currentStep, int totalSteps) {
        // Calculer la valeur interpolée entre les couleurs de départ et d'arrivée
        float ratio = (float) currentStep / totalSteps;
        int range = end - start;
        return Math.round(start + ratio * range);
    }
}