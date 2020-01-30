package tc.oc.pgm.discord;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.ExceptionEvent;
import net.dv8tion.jda.api.events.GatewayPingEvent;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.RawGatewayEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.ReconnectedEvent;
import net.dv8tion.jda.api.events.ResumedEvent;
import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.events.StatusChangeEvent;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.events.channel.category.GenericCategoryEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.category.update.GenericCategoryUpdateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.GenericStoreChannelEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.update.GenericStoreChannelUpdateEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.text.GenericTextChannelEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.update.GenericTextChannelUpdateEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateNSFWEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateParentEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateSlowmodeEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateTopicEvent;
import net.dv8tion.jda.api.events.channel.voice.GenericVoiceChannelEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.voice.update.GenericVoiceChannelUpdateEvent;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdateBitrateEvent;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdateParentEvent;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdateUserLimitEvent;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.emote.EmoteRemovedEvent;
import net.dv8tion.jda.api.events.emote.GenericEmoteEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateRolesEvent;
import net.dv8tion.jda.api.events.emote.update.GenericEmoteUpdateEvent;
import net.dv8tion.jda.api.events.guild.GenericGuildEvent;
import net.dv8tion.jda.api.events.guild.GuildAvailableEvent;
import net.dv8tion.jda.api.events.guild.GuildBanEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildUnavailableEvent;
import net.dv8tion.jda.api.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.api.events.guild.UnavailableGuildJoinedEvent;
import net.dv8tion.jda.api.events.guild.UnavailableGuildLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GenericGuildMemberEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.events.guild.member.update.GenericGuildMemberUpdateEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateBoostTimeEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.update.GenericGuildUpdateEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateAfkChannelEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateAfkTimeoutEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateBannerEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateBoostCountEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateBoostTierEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateDescriptionEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateExplicitContentLevelEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateFeaturesEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateIconEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateMFALevelEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateMaxMembersEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateMaxPresencesEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNotificationLevelEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateOwnerEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateRegionEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateSplashEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateSystemChannelEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateVanityCodeEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateVerificationLevelEvent;
import net.dv8tion.jda.api.events.guild.voice.GenericGuildVoiceEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceDeafenEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceGuildDeafenEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceGuildMuteEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMuteEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceSelfDeafenEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceSelfMuteEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceSuppressEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.http.HttpRequestEvent;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageBulkDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageEmbedEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.events.message.guild.GenericGuildMessageEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageEmbedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveAllEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageEmbedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageUpdateEvent;
import net.dv8tion.jda.api.events.message.priv.react.GenericPrivateMessageReactionEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveAllEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.role.GenericRoleEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.GenericRoleUpdateEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdateColorEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdateHoistedEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdateMentionableEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdateNameEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdatePositionEvent;
import net.dv8tion.jda.api.events.self.GenericSelfUpdateEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateAvatarEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateEmailEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateMFAEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateNameEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateVerifiedEvent;
import net.dv8tion.jda.api.events.user.GenericUserEvent;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.GenericUserPresenceEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateActivityOrderEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateAvatarEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateDiscriminatorEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordListener extends ListenerAdapter {
  private static void log(GenericEvent event) {
    System.out.println(event.getClass().toString());
  }

  public void onGenericEvent(@Nonnull GenericEvent event) {
    log(event);
  }

  public void onGenericUpdate(@Nonnull UpdateEvent<?, ?> event) {
    log(event);
  }

  public void onRawGateway(@Nonnull RawGatewayEvent event) {
    log(event);
  }

  public void onGatewayPing(@Nonnull GatewayPingEvent event) {
    log(event);
  }

  // JDA Events
  public void onReady(@Nonnull ReadyEvent event) {
    log(event);
  }

  public void onResume(@Nonnull ResumedEvent event) {
    log(event);
  }

  public void onReconnect(@Nonnull ReconnectedEvent event) {
    log(event);
  }

  public void onDisconnect(@Nonnull DisconnectEvent event) {
    log(event);
  }

  public void onShutdown(@Nonnull ShutdownEvent event) {
    log(event);
  }

  public void onStatusChange(@Nonnull StatusChangeEvent event) {
    log(event);
  }

  public void onException(@Nonnull ExceptionEvent event) {
    log(event);
  }

  // User Events
  public void onUserUpdateName(@Nonnull UserUpdateNameEvent event) {
    log(event);
  }

  public void onUserUpdateDiscriminator(@Nonnull UserUpdateDiscriminatorEvent event) {
    log(event);
  }

  public void onUserUpdateAvatar(@Nonnull UserUpdateAvatarEvent event) {
    log(event);
  }

  public void onUserUpdateOnlineStatus(@Nonnull UserUpdateOnlineStatusEvent event) {
    log(event);
  }

  public void onUserUpdateActivityOrder(@Nonnull UserUpdateActivityOrderEvent event) {
    log(event);
  }

  public void onUserTyping(@Nonnull UserTypingEvent event) {
    log(event);
  }

  public void onUserActivityStart(@Nonnull UserActivityStartEvent event) {
    log(event);
  }

  public void onUserActivityEnd(@Nonnull UserActivityEndEvent event) {
    log(event);
  }

  // Self Events. Fires only in relation to the currently logged in account.
  public void onSelfUpdateAvatar(@Nonnull SelfUpdateAvatarEvent event) {
    log(event);
  }

  public void onSelfUpdateEmail(@Nonnull SelfUpdateEmailEvent event) {
    log(event);
  }

  public void onSelfUpdateMFA(@Nonnull SelfUpdateMFAEvent event) {
    log(event);
  }

  public void onSelfUpdateName(@Nonnull SelfUpdateNameEvent event) {
    log(event);
  }

  public void onSelfUpdateVerified(@Nonnull SelfUpdateVerifiedEvent event) {
    log(event);
  }

  // Message Events
  // Guild (TextChannel) Message Events
  public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
    log(event);
  }

  public void onGuildMessageUpdate(@Nonnull GuildMessageUpdateEvent event) {
    log(event);
  }

  public void onGuildMessageDelete(@Nonnull GuildMessageDeleteEvent event) {
    log(event);
  }

  public void onGuildMessageEmbed(@Nonnull GuildMessageEmbedEvent event) {
    log(event);
  }

  public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
    log(event);
  }

  public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent event) {
    log(event);
  }

  public void onGuildMessageReactionRemoveAll(@Nonnull GuildMessageReactionRemoveAllEvent event) {
    log(event);
  }

  // Private Message Events
  public void onPrivateMessageReceived(@Nonnull PrivateMessageReceivedEvent event) {
    log(event);
  }

  public void onPrivateMessageUpdate(@Nonnull PrivateMessageUpdateEvent event) {
    log(event);
  }

  public void onPrivateMessageDelete(@Nonnull PrivateMessageDeleteEvent event) {
    log(event);
  }

  public void onPrivateMessageEmbed(@Nonnull PrivateMessageEmbedEvent event) {
    log(event);
  }

  public void onPrivateMessageReactionAdd(@Nonnull PrivateMessageReactionAddEvent event) {
    log(event);
  }

  public void onPrivateMessageReactionRemove(@Nonnull PrivateMessageReactionRemoveEvent event) {
    log(event);
  }

  // Combined Message Events (Combines Guild and Private message into 1 event)
  public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
    log(event);
  }

  public void onMessageUpdate(@Nonnull MessageUpdateEvent event) {
    log(event);
  }

  public void onMessageDelete(@Nonnull MessageDeleteEvent event) {
    log(event);
  }

  public void onMessageBulkDelete(@Nonnull MessageBulkDeleteEvent event) {
    log(event);
  }

  public void onMessageEmbed(@Nonnull MessageEmbedEvent event) {
    log(event);
  }

  public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
    log(event);
  }

  public void onMessageReactionRemove(@Nonnull MessageReactionRemoveEvent event) {
    log(event);
  }

  public void onMessageReactionRemoveAll(@Nonnull MessageReactionRemoveAllEvent event) {
    log(event);
  }

  // StoreChannel Events
  public void onStoreChannelDelete(@Nonnull StoreChannelDeleteEvent event) {
    log(event);
  }

  public void onStoreChannelUpdateName(@Nonnull StoreChannelUpdateNameEvent event) {
    log(event);
  }

  public void onStoreChannelUpdatePosition(@Nonnull StoreChannelUpdatePositionEvent event) {
    log(event);
  }

  public void onStoreChannelUpdatePermissions(@Nonnull StoreChannelUpdatePermissionsEvent event) {
    log(event);
  }

  public void onStoreChannelCreate(@Nonnull StoreChannelCreateEvent event) {
    log(event);
  }

  // TextChannel Events
  public void onTextChannelDelete(@Nonnull TextChannelDeleteEvent event) {
    log(event);
  }

  public void onTextChannelUpdateName(@Nonnull TextChannelUpdateNameEvent event) {
    log(event);
  }

  public void onTextChannelUpdateTopic(@Nonnull TextChannelUpdateTopicEvent event) {
    log(event);
  }

  public void onTextChannelUpdatePosition(@Nonnull TextChannelUpdatePositionEvent event) {
    log(event);
  }

  public void onTextChannelUpdatePermissions(@Nonnull TextChannelUpdatePermissionsEvent event) {
    log(event);
  }

  public void onTextChannelUpdateNSFW(@Nonnull TextChannelUpdateNSFWEvent event) {
    log(event);
  }

  public void onTextChannelUpdateParent(@Nonnull TextChannelUpdateParentEvent event) {
    log(event);
  }

  public void onTextChannelUpdateSlowmode(@Nonnull TextChannelUpdateSlowmodeEvent event) {
    log(event);
  }

  public void onTextChannelCreate(@Nonnull TextChannelCreateEvent event) {
    log(event);
  }

  // VoiceChannel Events
  public void onVoiceChannelDelete(@Nonnull VoiceChannelDeleteEvent event) {
    log(event);
  }

  public void onVoiceChannelUpdateName(@Nonnull VoiceChannelUpdateNameEvent event) {
    log(event);
  }

  public void onVoiceChannelUpdatePosition(@Nonnull VoiceChannelUpdatePositionEvent event) {
    log(event);
  }

  public void onVoiceChannelUpdateUserLimit(@Nonnull VoiceChannelUpdateUserLimitEvent event) {
    log(event);
  }

  public void onVoiceChannelUpdateBitrate(@Nonnull VoiceChannelUpdateBitrateEvent event) {
    log(event);
  }

  public void onVoiceChannelUpdatePermissions(@Nonnull VoiceChannelUpdatePermissionsEvent event) {
    log(event);
  }

  public void onVoiceChannelUpdateParent(@Nonnull VoiceChannelUpdateParentEvent event) {
    log(event);
  }

  public void onVoiceChannelCreate(@Nonnull VoiceChannelCreateEvent event) {
    log(event);
  }

  // Category Events
  public void onCategoryDelete(@Nonnull CategoryDeleteEvent event) {
    log(event);
  }

  public void onCategoryUpdateName(@Nonnull CategoryUpdateNameEvent event) {
    log(event);
  }

  public void onCategoryUpdatePosition(@Nonnull CategoryUpdatePositionEvent event) {
    log(event);
  }

  public void onCategoryUpdatePermissions(@Nonnull CategoryUpdatePermissionsEvent event) {
    log(event);
  }

  public void onCategoryCreate(@Nonnull CategoryCreateEvent event) {
    log(event);
  }

  // PrivateChannel Events
  public void onPrivateChannelCreate(@Nonnull PrivateChannelCreateEvent event) {
    log(event);
  }

  public void onPrivateChannelDelete(@Nonnull PrivateChannelDeleteEvent event) {
    log(event);
  }

  // Guild Events
  public void onGuildReady(@Nonnull GuildReadyEvent event) {
    log(event);
  }

  public void onGuildJoin(@Nonnull GuildJoinEvent event) {
    log(event);
  }

  public void onGuildLeave(@Nonnull GuildLeaveEvent event) {
    log(event);
  }

  public void onGuildAvailable(@Nonnull GuildAvailableEvent event) {
    log(event);
  }

  public void onGuildUnavailable(@Nonnull GuildUnavailableEvent event) {
    log(event);
  }

  public void onUnavailableGuildJoined(@Nonnull UnavailableGuildJoinedEvent event) {
    log(event);
  }

  public void onUnavailableGuildLeave(@Nonnull UnavailableGuildLeaveEvent event) {
    log(event);
  }

  public void onGuildBan(@Nonnull GuildBanEvent event) {
    log(event);
  }

  public void onGuildUnban(@Nonnull GuildUnbanEvent event) {
    log(event);
  }

  // Guild Update Events
  public void onGuildUpdateAfkChannel(@Nonnull GuildUpdateAfkChannelEvent event) {
    log(event);
  }

  public void onGuildUpdateSystemChannel(@Nonnull GuildUpdateSystemChannelEvent event) {
    log(event);
  }

  public void onGuildUpdateAfkTimeout(@Nonnull GuildUpdateAfkTimeoutEvent event) {
    log(event);
  }

  public void onGuildUpdateExplicitContentLevel(
      @Nonnull GuildUpdateExplicitContentLevelEvent event) {
    log(event);
  }

  public void onGuildUpdateIcon(@Nonnull GuildUpdateIconEvent event) {
    log(event);
  }

  public void onGuildUpdateMFALevel(@Nonnull GuildUpdateMFALevelEvent event) {
    log(event);
  }

  public void onGuildUpdateName(@Nonnull GuildUpdateNameEvent event) {
    log(event);
  }

  public void onGuildUpdateNotificationLevel(@Nonnull GuildUpdateNotificationLevelEvent event) {
    log(event);
  }

  public void onGuildUpdateOwner(@Nonnull GuildUpdateOwnerEvent event) {
    log(event);
  }

  public void onGuildUpdateRegion(@Nonnull GuildUpdateRegionEvent event) {
    log(event);
  }

  public void onGuildUpdateSplash(@Nonnull GuildUpdateSplashEvent event) {
    log(event);
  }

  public void onGuildUpdateVerificationLevel(@Nonnull GuildUpdateVerificationLevelEvent event) {
    log(event);
  }

  public void onGuildUpdateFeatures(@Nonnull GuildUpdateFeaturesEvent event) {
    log(event);
  }

  public void onGuildUpdateVanityCode(@Nonnull GuildUpdateVanityCodeEvent event) {
    log(event);
  }

  public void onGuildUpdateBanner(@Nonnull GuildUpdateBannerEvent event) {
    log(event);
  }

  public void onGuildUpdateDescription(@Nonnull GuildUpdateDescriptionEvent event) {
    log(event);
  }

  public void onGuildUpdateBoostTier(@Nonnull GuildUpdateBoostTierEvent event) {
    log(event);
  }

  public void onGuildUpdateBoostCount(@Nonnull GuildUpdateBoostCountEvent event) {
    log(event);
  }

  public void onGuildUpdateMaxMembers(@Nonnull GuildUpdateMaxMembersEvent event) {
    log(event);
  }

  public void onGuildUpdateMaxPresences(@Nonnull GuildUpdateMaxPresencesEvent event) {
    log(event);
  }

  // Guild Member Events
  public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event) {
    log(event);
  }

  public void onGuildMemberLeave(@Nonnull GuildMemberLeaveEvent event) {
    log(event);
  }

  public void onGuildMemberRoleAdd(@Nonnull GuildMemberRoleAddEvent event) {
    log(event);
  }

  public void onGuildMemberRoleRemove(@Nonnull GuildMemberRoleRemoveEvent event) {
    log(event);
  }

  // Guild Member Update Events
  public void onGuildMemberUpdateNickname(@Nonnull GuildMemberUpdateNicknameEvent event) {
    log(event);
  }

  public void onGuildMemberUpdateBoostTime(@Nonnull GuildMemberUpdateBoostTimeEvent event) {
    log(event);
  }

  // Guild Voice Events
  public void onGuildVoiceUpdate(@Nonnull GuildVoiceUpdateEvent event) {
    log(event);
  }

  public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
    log(event);
  }

  public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent event) {
    log(event);
  }

  public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
    log(event);
  }

  public void onGuildVoiceMute(@Nonnull GuildVoiceMuteEvent event) {
    log(event);
  }

  public void onGuildVoiceDeafen(@Nonnull GuildVoiceDeafenEvent event) {
    log(event);
  }

  public void onGuildVoiceGuildMute(@Nonnull GuildVoiceGuildMuteEvent event) {
    log(event);
  }

  public void onGuildVoiceGuildDeafen(@Nonnull GuildVoiceGuildDeafenEvent event) {
    log(event);
  }

  public void onGuildVoiceSelfMute(@Nonnull GuildVoiceSelfMuteEvent event) {
    log(event);
  }

  public void onGuildVoiceSelfDeafen(@Nonnull GuildVoiceSelfDeafenEvent event) {
    log(event);
  }

  public void onGuildVoiceSuppress(@Nonnull GuildVoiceSuppressEvent event) {
    log(event);
  }

  // Role events
  public void onRoleCreate(@Nonnull RoleCreateEvent event) {
    log(event);
  }

  public void onRoleDelete(@Nonnull RoleDeleteEvent event) {
    log(event);
  }

  // Role Update Events
  public void onRoleUpdateColor(@Nonnull RoleUpdateColorEvent event) {
    log(event);
  }

  public void onRoleUpdateHoisted(@Nonnull RoleUpdateHoistedEvent event) {
    log(event);
  }

  public void onRoleUpdateMentionable(@Nonnull RoleUpdateMentionableEvent event) {
    log(event);
  }

  public void onRoleUpdateName(@Nonnull RoleUpdateNameEvent event) {
    log(event);
  }

  public void onRoleUpdatePermissions(@Nonnull RoleUpdatePermissionsEvent event) {
    log(event);
  }

  public void onRoleUpdatePosition(@Nonnull RoleUpdatePositionEvent event) {
    log(event);
  }

  // Emote Events
  public void onEmoteAdded(@Nonnull EmoteAddedEvent event) {
    log(event);
  }

  public void onEmoteRemoved(@Nonnull EmoteRemovedEvent event) {
    log(event);
  }

  // Emote Update Events
  public void onEmoteUpdateName(@Nonnull EmoteUpdateNameEvent event) {
    log(event);
  }

  public void onEmoteUpdateRoles(@Nonnull EmoteUpdateRolesEvent event) {
    log(event);
  }

  // Debug Events
  public void onHttpRequest(@Nonnull HttpRequestEvent event) {
    log(event);
  }

  // Generic Events
  public void onGenericMessage(@Nonnull GenericMessageEvent event) {
    log(event);
  }

  public void onGenericMessageReaction(@Nonnull GenericMessageReactionEvent event) {
    log(event);
  }

  public void onGenericGuildMessage(@Nonnull GenericGuildMessageEvent event) {
    log(event);
  }

  public void onGenericGuildMessageReaction(@Nonnull GenericGuildMessageReactionEvent event) {
    log(event);
  }

  public void onGenericPrivateMessage(@Nonnull GenericPrivateMessageEvent event) {
    log(event);
  }

  public void onGenericPrivateMessageReaction(@Nonnull GenericPrivateMessageReactionEvent event) {
    log(event);
  }

  public void onGenericUser(@Nonnull GenericUserEvent event) {
    log(event);
  }

  public void onGenericUserPresence(@Nonnull GenericUserPresenceEvent event) {
    log(event);
  }

  public void onGenericSelfUpdate(@Nonnull GenericSelfUpdateEvent event) {
    log(event);
  }

  public void onGenericStoreChannel(@Nonnull GenericStoreChannelEvent event) {
    log(event);
  }

  public void onGenericStoreChannelUpdate(@Nonnull GenericStoreChannelUpdateEvent event) {
    log(event);
  }

  public void onGenericTextChannel(@Nonnull GenericTextChannelEvent event) {
    log(event);
  }

  public void onGenericTextChannelUpdate(@Nonnull GenericTextChannelUpdateEvent event) {
    log(event);
  }

  public void onGenericVoiceChannel(@Nonnull GenericVoiceChannelEvent event) {
    log(event);
  }

  public void onGenericVoiceChannelUpdate(@Nonnull GenericVoiceChannelUpdateEvent event) {
    log(event);
  }

  public void onGenericCategory(@Nonnull GenericCategoryEvent event) {
    log(event);
  }

  public void onGenericCategoryUpdate(@Nonnull GenericCategoryUpdateEvent event) {
    log(event);
  }

  public void onGenericGuild(@Nonnull GenericGuildEvent event) {
    log(event);
  }

  public void onGenericGuildUpdate(@Nonnull GenericGuildUpdateEvent event) {
    log(event);
  }

  public void onGenericGuildMember(@Nonnull GenericGuildMemberEvent event) {
    log(event);
  }

  public void onGenericGuildMemberUpdate(@Nonnull GenericGuildMemberUpdateEvent event) {
    log(event);
  }

  public void onGenericGuildVoice(@Nonnull GenericGuildVoiceEvent event) {
    log(event);
  }

  public void onGenericRole(@Nonnull GenericRoleEvent event) {
    log(event);
  }

  public void onGenericRoleUpdate(@Nonnull GenericRoleUpdateEvent event) {
    log(event);
  }

  public void onGenericEmote(@Nonnull GenericEmoteEvent event) {
    log(event);
  }

  public void onGenericEmoteUpdate(@Nonnull GenericEmoteUpdateEvent event) {
    log(event);
  }
}
