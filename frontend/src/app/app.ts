import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from './components/navbar/navbar.component';
import { Footer } from './components/footer/footer.component';
import { AboutModal } from './pages/about-modal/about-modal';
import { DonateModal } from './pages/donate-modal/donate-modal';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Navbar, Footer, AboutModal, DonateModal],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {}