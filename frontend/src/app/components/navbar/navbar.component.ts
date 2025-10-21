import { Component } from '@angular/core';
import { Router } from '@angular/router';

declare var bootstrap: any;

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class Navbar {
  constructor(private router: Router) {}

  goHome() {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      window.location.reload();
    });
  }

  goAbout() {
    this.router.navigate(['/about']);
  }

  openAboutModal() {
    debugger;
    const modalEl = document.getElementById('aboutModal');
    if (modalEl) {
      const modal = bootstrap.Modal.getOrCreateInstance(modalEl);
      modal.show();
    }
  }

  openDonateModal() {
    debugger;
    const modalEl = document.getElementById('donateModal');
    if (modalEl) {
      const modal = bootstrap.Modal.getOrCreateInstance(modalEl);
      modal.show();
    }
  }
}