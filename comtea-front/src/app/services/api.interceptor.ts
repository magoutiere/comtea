import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {tap} from "rxjs/operators";
import {NotificationService} from "./notification.service";

@Injectable()
export class ApiInterceptor implements HttpInterceptor {

  constructor(private notificationService: NotificationService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      tap(x => x, err => {
        const erreurClient = err.error instanceof ErrorEvent;

        let message = 'Erreur technique';
        if (erreurClient) {
          message = err.error.message;
        } else {
          const erreurs = JSON.parse(err.error).errors;
          if (erreurs && Array.isArray(erreurs)) {
            message = erreurs.map((e: any) => e.defaultMessage).join(",")
          }
        }

        this.notificationService.erreur({titre: 'Erreur', message});
        return throwError(message);
      })
    );
  }
}
