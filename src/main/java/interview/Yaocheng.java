package interview;

public class Yaocheng {
    public String generateAssetKey (String pattern, int length, String currentKey) {
        int keyLength = currentKey.length();
        int alphaLength = keyLength - length;
        String alpha = currentKey.substring(0,alphaLength);
        if (isAllNine(currentKey) || length != (keyLength-alphaLength)) return currentKey;

        String num = currentKey.substring(alphaLength,keyLength);
        long temp = Long.parseLong(num);
        temp++;
        num = String.valueOf(temp);
        int dist = length - num.length();
        for (int i = 0; i < dist; i++) {
            alpha += "0";
        }
        return alpha + String.valueOf(num);
    }
    public boolean isAllNine(String currentKey){
        for (int i = 0; i < currentKey.length(); i++) {
            if (currentKey.charAt(i) != '9') {
                return false;
            }
        }
        return true;
    }
}
