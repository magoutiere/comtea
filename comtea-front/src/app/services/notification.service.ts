import {Injectable} from '@angular/core';
import {MessageService} from "primeng/api";

export interface Notification {
  titre?: string,
  message: string
}

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private messageService: MessageService) {
  }

  success(notification: Notification) {
    this.messageService.add({severity: 'success', summary: notification.titre, detail: notification.message})
  }

  erreur(notification: Notification) {
    this.messageService.add({severity: 'error', summary: notification.titre, detail: notification.message})
  }
}
