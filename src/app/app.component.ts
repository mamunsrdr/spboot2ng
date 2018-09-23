import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  greetings: string;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get("/rest/greetings").subscribe((result: any) => {
      this.greetings = result.message;
    });
  }
}
