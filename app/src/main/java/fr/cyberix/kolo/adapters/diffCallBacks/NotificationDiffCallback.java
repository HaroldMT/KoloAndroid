package fr.cyberix.kolo.adapters.diffCallBacks;

import com.leodroidcoder.genericadapter.BaseDiffCallback;

import java.util.List;

import fr.cyberix.kolo.model.entities.KoloNotification;

public class NotificationDiffCallback extends BaseDiffCallback<KoloNotification> {
	public NotificationDiffCallback(List<KoloNotification> oldItems, List<KoloNotification> newItems) {
		super(oldItems, newItems);
	}
	
	@Override
	public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
		return getOldItems().get(oldItemPosition).getIdNotification() == getNewItems().get(newItemPosition).getIdNotification();
	}
	
	@Override
	public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
		KoloNotification oldHistory = getOldItems().get(oldItemPosition);
		KoloNotification newHistory = getNewItems().get(newItemPosition);
		return oldHistory.getCreationDate().equals(newHistory.getCreationDate())
				&& oldHistory.getMessage() == newHistory.getMessage()
				&& oldHistory.getTitle() == newHistory.getTitle();
	}
}
