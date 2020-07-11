package ru.drygok.commandblocker;

public enum Permissions {
    
    COMMAND_RELOAD("command", "reload"),
    BYPASS_COMMAND("bypass", "commands"),
    BYPASS_SYMBOLS("bypass", "symbols");

    private String permission;
    Permissions(String catalog, String perm) {
        permission = "commandblocker." + catalog + "." + perm;
    }
    public String getPermission() {
        return permission;
    }
}
