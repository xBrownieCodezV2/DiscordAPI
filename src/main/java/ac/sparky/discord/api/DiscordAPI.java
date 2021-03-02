package ac.sparky.discord.api;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import lombok.Getter;
import org.bukkit.plugin.Plugin;

@Getter
public class DiscordAPI {
    private WebhookClient webhookClient;

    public void setupWebhook(String url, Plugin plugin) {
        this.webhookClient = WebhookClient.withUrl(url);
        ac.sparky.discord.Plugin.getInstance().getLogger()
                .info("New instance of DiscordAPI has been hooked to the plugin " + plugin.getName());
    }

    public void sendMessage(int color, String title, String description, String footer) {
        if (this.webhookClient != null) {
            ac.sparky.discord.Plugin.getInstance().getExecutor()
                    .execute(() -> this.webhookClient.send(new WebhookEmbedBuilder().setColor(color)
                            .setTitle(new WebhookEmbed.EmbedTitle(title, null)).setDescription(description)
                            .setFooter(new WebhookEmbed.EmbedFooter(footer, null)).build()));
        }
    }
}
