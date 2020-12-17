package net.labymod.serverapi.common.serverinteraction;

import com.google.gson.JsonObject;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.UUID;
import net.labymod.serverapi.api.payload.PayloadCommunicator;
import net.labymod.serverapi.api.serverinteraction.Watermark;

@Singleton
public class DefaultWatermark implements Watermark {

  private static final String WATERMARK_CHANNEL = "watermark";
  private final PayloadCommunicator payloadCommunicator;

  @Inject
  private DefaultWatermark(PayloadCommunicator payloadCommunicator) {
    this.payloadCommunicator = payloadCommunicator;
  }

  /** {@inheritDoc} */
  @Override
  public void displayWatermark(UUID uniqueId, boolean showWatermark) {
    JsonObject watermarkObject = new JsonObject();
    watermarkObject.addProperty("visible", showWatermark);

    this.payloadCommunicator.sendLabyModMessage(uniqueId, WATERMARK_CHANNEL, watermarkObject);
  }
}
