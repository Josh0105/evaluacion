import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontEndEvaluacion';

  ngOnInit(): void {
    if(window.location.pathname=='/'){
      window.location.href="inicio";
    }
  }

}

